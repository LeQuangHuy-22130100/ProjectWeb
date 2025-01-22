<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đặt lại mật khẩu</title>
	<link rel="stylesheet" href="./CSS/Reset_Password_Style.css">
</head>
<body>
	<div class="reset-container">
		<form action="">
			<div class="form-group">
				<input name="newPassword" type="password" id="Pass_Login" placeholder="Mật Khẩu Mới" required>
			</div>
			<div class="form-group">
				<input name="confirmPassword" type="password" id="Pass_Login" placeholder="Nhập Lại Mật Khẩu Mới" required>
			</div>
			<button type="submit" class="btn"><a href="./login.jsp">Đặt lại</a></button>
		</form>
	</div>
</body>
</html>