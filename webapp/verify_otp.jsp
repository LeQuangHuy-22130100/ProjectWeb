<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<title>Xác nhận OTP</title>
	<link rel="stylesheet" href="./CSS/Verify_OTP.css">
</head>
<body>
	<div class="otp-container">
		<form action="">
			<h1>Mã OTP</h1>
			<input type="hidden" name="action" value="verifyOTP">
			<div class="form-group">
				<input name="otp" type="text" placeholder="OTP" maxlength="6" required>
			</div>
			<button type="submit" class="btn"><a href="./reset_password.jsp">Xác nhận</a></button>
		</form>
	</div>
</body>
</html>