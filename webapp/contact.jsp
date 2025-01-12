<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<title>Liên hệ</title>
	<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
        }

        form {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }

        input[type="text"]:focus, textarea:focus {
            border-color: #007BFF;
            outline: none;
            box-shadow: 0 0 4px rgba(0, 123, 255, 0.5);
        }

        input[type="submit"] {
        	display: block;
        	margin: 0 auto;
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        footer {
            margin-top: 50px;
            text-align: center;
            font-size: 14px;
            color: gray;
        }

        footer hr {
            margin: 20px auto;
            width: 80%;
            border: 0;
            border-top: 1px solid #ddd;
        }
    </style>
</head>

<body>
	<form method="POST" action="ContactServlet">
		<label for="name">Tên:</label>
		<input type="text" id="name" name="name" required><br><br>
		
		<label for="email">Email:</label>
		<input type="text" id="email" name="email" required><br><br>
		
		<label for="message">Phản hồi:</label><br>
		<textarea id="message" name="message" rows="6" cols="40" required></textarea>
		
		<input type="submit" value="Gửi">
	</form>
	
	<div id="popup" style="display: none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); background: white; padding: 20px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); border-radius: 8px; text-align: center;">
        <p id="popupMessage"></p>
        <button onclick="closePopup()">Đóng</button>
    </div>
</body>

<footer style="margin-top: 50px; text-align: center; font-size: 14px; color: gray;">
	<hr>
	<p>&copy; Sofa 2025. All ready reserved.</p>	
</footer>
</html>