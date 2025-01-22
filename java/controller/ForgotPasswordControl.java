package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;


@WebServlet(name = "/ForgotPasswordControl", value = "/forgot_password.jsp")
public class ForgotPasswordControl extends HttpServlet {
	private UserService userService;
	
	@Override
    public void init() {
        userService = new UserService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        if ("verifyOTP".equals(action)) {
            request.getRequestDispatcher("verify_otp.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("sendOTP".equals(action)) {
			handleSendOTP(request, response);
		} else if ("verifyOTP".equals(action)) {
			handleVerifyOTP(request, response);
		} else if ("resetPassword".equals(action)) {
			handleResetPassword(request, response);
		}
	}

	private void handleSendOTP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        HttpSession session = request.getSession();
        
        try {
            if (userService.sendOTP(email)) {
                session.setAttribute("email", email);
                request.setAttribute("successNote", "Mã OTP đã được gửi đến email của bạn. Vui lòng kiểm tra hộp thư.");
                request.getRequestDispatcher("verify_otp.jsp").forward(request, response);
                return;
            } else {
                request.setAttribute("errorNote", "Email không tồn tại trong hệ thống.");
            }
        } catch (MessagingException e) {
            e.printStackTrace();
            request.setAttribute("errorNote", "Đã xảy ra lỗi khi gửi email. Vui lòng thử lại sau.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorNote", "Đã xảy ra lỗi kết nối cơ sở dữ liệu. Vui lòng thử lại sau.");
        }
        
        request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
	}
	
	private void handleVerifyOTP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otp = request.getParameter("otp");
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        
        if (userService.verifyOTP(email, otp)) {
            request.getRequestDispatcher("reset_password.jsp").forward(request, response);
        } else {
            request.setAttribute("errorNote", "Mã OTP không chính xác hoặc đã hết hạn.");
            request.getRequestDispatcher("verify_otp.jsp").forward(request, response);
        }
	}
	
	private void handleResetPassword(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        
        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("errorNote", "Mật khẩu xác nhận không khớp.");
            request.getRequestDispatcher("reset_password.jsp").forward(request, response);
            return;
        }
        
        try {
            if (userService.resetPassword(email, newPassword)) {
                session.removeAttribute("email");
                request.setAttribute("successNote", "Mật khẩu đã được đặt lại thành công.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("errorNote", "Không thể đặt lại mật khẩu. Vui lòng thử lại.");
                request.getRequestDispatcher("reset_password.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorNote", "Đã xảy ra lỗi. Vui lòng thử lại sau.");
            request.getRequestDispatcher("reset_password.jsp").forward(request, response);
        }
    }

}
