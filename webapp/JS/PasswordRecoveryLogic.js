/**
 * 
 */

document.addEventListener("DOMContentLoaded", function () {
    const emailForm = document.getElementById("emailForm");
    const OTPForm = document.getElementById("OTPForm");
    const passwordRecoveryForm = document.getElementById("passwordRecoveryForm");
    
    // Xử lý gửi email
    emailForm.addEventListener("submit", function(e) {
        e.preventDefault();
        const email = document.querySelector("input[name='email']").value;
        
        if (!validateEmail(email)) {
            alert("Vui lòng nhập email hợp lệ.");
            return;
        }

        const data = new URLSearchParams();
        data.append('action', 'sendOTP');
        data.append('email', email);

        fetch('forgot_password', {
            method: 'POST',
            body: data
        })
        .then(response => response.text())
        .then(message => {
            if(message === 'Gửi mã OTP thành công') {
                document.querySelector('.email-container').classList.remove('active');
                document.querySelector('.OTP-container').classList.add('active');
            }
            alert(message);
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Có lỗi xảy ra khi gửi OTP');
        });
    });

    // Xử lý xác thực OTP
    OTPForm.addEventListener("submit", function(e) {
        e.preventDefault();
        const otp = document.querySelector("input[name='otp']").value;

        if (otp.length !== 6) {
            alert("OTP phải có 6 ký tự.");
            return;
        }

        const data = new URLSearchParams();
        data.append('action', 'verifyOTP');
        data.append('otp', otp);

        fetch('forgot_password', {
            method: 'POST',
            body: data
        })
        .then(response => response.text())
        .then(message => {
            if(message === 'OTP verified') {
                document.querySelector('.OTP-container').classList.remove('active');
                document.querySelector('.recovery-container').classList.add('active');
            } else {
                alert(message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Có lỗi xảy ra khi xác thực OTP');
        });
    });

    // Xử lý đặt lại mật khẩu
    passwordRecoveryForm.addEventListener("submit", function(e) {
        e.preventDefault();
        const newPassword = document.querySelector("input[name='newPassword']").value;
        const confirmPassword = document.querySelector("input[name='confirmPassword']").value;

        if (newPassword !== confirmPassword) {
            alert("Mật khẩu không khớp!");
            return;
        }

        const data = new URLSearchParams();
        data.append('action', 'resetPassword');
        data.append('newPassword', newPassword);
        data.append('confirmPassword', confirmPassword);

        fetch('forgot_password', {
            method: 'POST',
            body: data
        })
        .then(response => response.text())
        .then(message => {
            alert(message);
            if(message === 'Khôi phục mật khẩu thành công') {
                window.location.href = 'login.jsp';
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Có lỗi xảy ra khi đặt lại mật khẩu');
        });
    });

    // Hàm kiểm tra email hợp lệ
    function validateEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
}); 