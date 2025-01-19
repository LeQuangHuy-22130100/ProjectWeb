<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zenry
  Date: 19/01/2025
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

</body>
</html>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Management System</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f9;
    }

    header {
      background-color: #333;
      color: #fff;
      padding: 10px 20px;
      text-align: center;
    }

    .main {
      display: flex;
    }

    .sidebar {
      width: 250px;
      background-color: #2c3e50;
      color: #fff;
      padding: 20px;
      height: 100vh;
      position: fixed;
    }

    .sidebar h2 {
      margin-top: 0;
      margin-bottom: 20px;
    }

    .sidebar ul {
      list-style: none;
      padding: 0;
    }

    .sidebar ul li {
      margin-bottom: 10px;
    }

    .sidebar ul li a {
      color: #fff;
      text-decoration: none;
      padding: 10px;
      display: block;
      border-radius: 4px;
    }

    .sidebar ul li a:hover {
      background-color: #34495e;
    }

    .content {
      margin-left: 270px;
      padding: 20px;
      width: calc(100% - 270px);
    }

    h1, h2 {
      margin: 0 0 20px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
    }

    table th, table td {
      padding: 10px;
      text-align: left;
      border: 1px solid #ddd;
    }

    table th {
      background-color: #f4f4f4;
    }

    button {
      padding: 8px 12px;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    .btn-delete {
      background-color: #dc3545;
    }

    section {
      margin-bottom: 40px;
      text-align: center;
    }
  </style>
</head>
<body>
<header>
  <h1>Management System</h1>
</header>
<div class="main">
  <div class="sidebar">
    <h2>Navigation</h2>
    <ul>
      <li><a href="ProductManagement.html">Quản lý sản phẩm</a></li>
      <li><a href="./ClientManagement.html">Quản lý khách hàng</a></li>
      <li><a href="#information-management">Thông tin quản lý</a></li>
    </ul>
  </div>
  <div class="content">
    <!-- Product Management -->
    <section id="product-management">
      <h2>Quản lý sản phẩm</h2>
      <table>
        <thead>
        <tr>
          <th>ID</th>
          <th>Image</th>
          <th>Name</th>
          <th>Type</th>
          <th>Size</th>
          <th>Stock</th>
          <th>Price</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productManagement}" var="pm">
          <tr>
            <td>${pm.id}</td>
            <td><img src="${pm.image}" alt="Product 1" width="50"></td>
            <td>${pm.name}</td>
            <td>${pm.matarial}</td>
            <td>${pm.sizeID.size}</td>
            <td>${pm.stock}</td>
            <td>${pm.price}</td>
            <td><button class="btn-delete"><a href="delete?id=${pm.id}">Delete</a></button></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </section>

    <!-- Information Management -->
    <section id="information-management">
      <h2>Information Management</h2>
      <p>Here you can manage additional information for your system. This section can be customized as needed.</p>
    </section>
  </div>
</div>
</body>
</html>
