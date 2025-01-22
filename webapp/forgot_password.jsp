<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<title>Quên mật khẩu</title>
	<link rel="stylesheet" href="./CSS/Forgot_Password_Style.css">
</head>
<body>
	<div class="container">
		<form action="">
			<div class="form-group">
				<input name="email" type="email" placeholder="Email" required>
			</div>
			<button type="submit" class="btn"><a href="./verify_otp.jsp">Gửi</a></button> 
		</form>
		<div class="notification">
			<%
				String errorNote = (String) request.getAttribute("errorNote");
				String successNote = (String) request.getAttribute("successNote");
				if (errorNote != null) {
			%>
				<p style="color: red"><%= errorNote %></p>
			<%
				} else if (successNote != null) {
			%>
				<p style="color: green;"><%= successNote %></p>
			<% } %>		
		</div>
	</div>
</body>
</html>