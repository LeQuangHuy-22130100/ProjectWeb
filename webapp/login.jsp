<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- icon -->
	<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
	<link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet">
	<title>Login Register</title>
	<!-- CSS -->
	<link rel="stylesheet" href="./CSS/Login_Styling.css">
</head>

<body>
	<div class="contain_login_Register" id="LoginAccess">
		<div class="wrapper_Login">
			<form action="">
				<h1>Đăng nhập tài khoản</h1>
				<br>
				<p class="text-danger" style="text-align: center; color: #9b2805">
					<% if (request.getAttribute("mess") != null) { %>
					${mess}
					<% } %>
			s	</p>
				<div class="inputBox">
					<input name="username" type="text" placeholder="Tên Đăng Nhập" required>
					<i class="ri-mail-fill"></i>
				</div>
				<div class="inputBox">
					<input name="password" type="password" id="Pass_Login" placeholder="Mật Khẩu" required>
					<i class="ri-eye-off-fill" id="Icon_Login" style="right: 5%; cursor: pointer;"></i>
				</div>

				<div class="remember_forgot">
					<label><input type="checkbox">Nhớ tôi</label>
					<a href="#">Bạn Quên Mật Khẩu?</a>
				</div>
				<button type="submit" class="btn"><a href="./HomePage.jsp">Đăng Nhập</a></button>

				<div class="register">
					<p>
						Bạn Chưa Có Tài Khoản?
						<a href="#" id="switchToRegister"> Đăng Ký </a>
					</p>
				</div>
			</form>
		</div>

		<div class="wrapper_Register">
			<form action="">
				<h1>Đăng ký tài khoảng</h1>

				<div class="Name">
					<div class="first_name">
						<input type="text" placeholder="Tên" required>
					</div>
					<div class="last_name">
						<input type="text" placeholder="Tên Đệm" required>
					</div>
				</div>

				<div class="inputBox_register">
					<input type="text" placeholder="Tên Đăng Nhập" required>
					<i class="ri-mail-fill"></i>
				</div>
				<div class="inputBox_register">
					<input type="password" id="Pass_Register" placeholder="Mật Khẩu"required>
					<i class="ri-eye-off-fill" id="Icon_Register"></i>
				</div>

				<a href="TrangChu.html"><button type="submit" class="btn">Tạo Tài Khoản</button></a>

				<div class="login">
					<p>
						Bạn Đã Có Tài Khoản? 
						<a href="#" id="switchToLogin"> Đăng nhập </a>
					</p>
				</div>
			</form>
		</div>
	</div>
	<script src="../JS/Hide_Password.js"></script>
</body>
</html>