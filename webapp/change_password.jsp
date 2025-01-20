<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<title>Đổi mật khẩu</title>
	<link rel="stylesheet" href="./CSS/Change_Password_Style.css">
</head>
<body>
	<div class="container">
		<% if(request.getAttribute("mess") != null) { %>
            <div class="error-message">
                <%= request.getAttribute("mess") %>
            </div>
        <% } %>
		<form action="">
			<h1>Đổi mật khẩu</h1>
			<div class="form-group">
				<label for="currentPassword">Mật khẩu hiện tại:</label><br>
				<input type="password" id="currentPassword" name="currentPassword" required><br><br>
			</div>
		
			<div class="form-group">
				<label for="newPassword">Mật khẩu mới:</label><br>
				<input type="password" id="newPassword" name="newPassword" required><br><br>
			</div>
		
			<div class="form-group">
				<label for="confirmPassword">Nhập lại mật khẩu mới:</label><br>
				<input type="password" id="confirmPassword" name="confirmPassword" required><br><br>
			</div>
		
			<button type="submit" class="submit-btn">Đổi mật khẩu</button>
		</form>
	</div>
	<script src="../JS/Hide_Password.js"></script>
</body>
</html>