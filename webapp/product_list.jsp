<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<title>Danh sách sản phẩm</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			padding: 20px;
		}
		.product-grid {
			display: grid;
			grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
			gap: 20px;
			padding: 20px 0;
		}
		.product {
			border: 1px solid #ccc;
			padding: 15px;
			margin: 10px 0;
			display: flex;
			flex-direction: column;
			align-items: center;
			text-align: center;
			transition: transform 0.2s;
		}
		.product:hover {
			transform: translateY(-5px);
			box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
		}
		.product img {
			max-width: 100px;
			margin-bottom: 15px;
		}
		.product h3 {
			width: 100%;
			margin: 10px 0;
			color: #333;
			word-wrap: break-word; 
		}
		.product p {
			width: 100%;
			margin: 8px 0;
			color: #666;
			word-wrap: break-word;
		}
		.product p:last-child {
			font-weight: bold;
			color: #007bff;
			margin-top: auto;
		}
		.pagination {
			margin-top: 30px;
			text-align: center
		}
		
		.pagination a {
			margin: 0 5px;
			padding: 5px 10px;
			border: 1px solid #ccc;
			text-decoration: none;
			color: #000;
			border-radius: 4px;
		}
		.pagination a:hover {
			background-color: #f0f0f0;
		}
		.pagination a.current {
			background-color: #007bff;
			color: #fff;
			font-weight: bold;
			border-color: #007bff;
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
    <div class="product-grid">
    	<c:forEach var="product" items="${productList}">
        	<div class="product">
            	<img src="images/${product.image}" alt="${product.name}">
            	<h3>${product.name}</h3>
            	<p>${product.description}</p>
            	<p>Giá: ${product.price} VND</p>
        	</div>
    	</c:forEach>
    </div>

    <div class="pagination">
        <c:forEach begin="1" end="${totalPages}" var="i">
            <a href="?page=${i}" class="${i == currentPage ? 'current' : ''}">${i}</a>
        </c:forEach>
    </div>
</body>

<footer style="margin-top: 50px; text-align: center; font-size: 14px; color: gray;">
	<hr>
	<p>&copy; Sofa 2025. All ready reserved.</p>	
</footer>
</html>