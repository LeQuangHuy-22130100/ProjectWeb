
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sofa Shop</title>
    <link rel="stylesheet" href="JSPWeb/CSS/Product.css">
    <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
            integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>

<body>
<div class="img_Background">
    <img src="./JSPWeb/IMG/headerimage.jpg" alt="Sofa Shop Header">
</div>

<header class="header_home_menu">
    <img src="./JSPWeb/IMG/logo.jpg" alt="" width="50">
    <ul class="menu">
        <li>
            <a href="./HomePage">
                <span class="text_header"> TRANG CHỦ</span>
            </a>
        </li>
        <li>
            <a href="#">
                <span class="text_header"> SẢN PHẨM</span>
            </a>
        </li>
        <li>
            <a href="./ShowRoom.jsp">
                <span class="text_header"> SHOWROOM</span>
            </a>
        </li>
        <li>
            <a href="#">
                <span class="text_header"> LIÊN HỆ </span>
            </a>
        </li>
    </ul>

    <ul class="social_icon">
        <%--        logout--%>
        <c:if test="${sessionScope.acc != null}">
            <li>
                <i class="fa-solid fa-user" style="color: rgb(255, 255, 255);"></i>
                <ul class="dropdown">
                    <li><i class="bi bi-person-circle"></i><span>${sessionScope.acc.username}</span></li>
                    <c:if test="${sessionScope.acc.isAdmin == 1}">
                        <li>
                            <h5>Hello ${sessionScope.acc.username} (admin)</h5>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.acc.isClient == 1}">
                        <li>
                            <h5>SĐT: +84 xxx.xxx.xxx</h5>
                        </li>
                    </c:if>

                    <li><i class="bi bi-box-arrow-right"></i> <span><a href="Login.jsp">Đăng Xuất</a></span></li>
                </ul>
            </li>
        </c:if>

        <%--        login--%>
        <c:if test="${sessionScope.acc == null}">
            <li>
                <i class="fa-solid fa-user" style="color: rgb(255, 255, 255);"></i>
                <ul class="dropdown">
                    <li><i class="bi bi-box-arrow-right"></i> <span><a href="./Login.jsp">Đăng Nhập</a></span></li>
                </ul>
            </li>
        </c:if>
<%--        <li>--%>
<%--                        <i class="fa-solid fa-user" style="color: rgb(255, 255, 255);"></i>--%>
<%--                        <ul class="dropdown">--%>
<%--                            <li><i class="bi bi-person-circle"></i> <span>${sessionScope.acc.username}</span></li>--%>
<%--                            <li>--%>
<%--                                <h5>SĐT: +84 xxx.xxx.xxx</h5>--%>
<%--                            </li>--%>
<%--                            <li><i class="bi bi-box-arrow-right"></i> <span><a href="./Login.jsp">Đăng Xuất</a></span></li>--%>
<%--                        </ul>--%>
<%--        </li>--%>
        <li>
            <i class="fa-solid fa-heart" style="color: #ffffff;"></i>
        </li>
        <li>
            <a href="#">
                <i class="fas fa-shopping-cart"></i>
            </a>
        </li>
    </ul>
</header>

<main class="container">
<%--    <div class="filters">--%>
<%--        <select id="product-category" onchange="location = this.value;">--%>
<%--            <option value="">Bộ sản phẩm</option>--%>
<%--            <c:forEach items="${CateProduct}" var="cp">--%>
<%--                <option value="category?cateID=${cp.categoryId}">${cp.name}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
<%--        <select id="size">--%>
<%--            <option value="">Kích thước</option>--%>
<%--            <option value="big">Trên 3m</option>--%>
<%--            <option value="medium">2,5m - 3m</option>--%>
<%--            <option value="small">dưới 2,5m</option>--%>
<%--        </select>--%>
<%--        <select id="price-range">--%>
<%--            <option value="">Khoảng giá</option>--%>
<%--            <option value="">$1000 - $5000</option>--%>
<%--            <option value="big">$5000 - $12000</option>--%>
<%--            <option value="medium">Trên $12000</option>--%>
<%--        </select>--%>
<%--    </div>--%>
    <div class="filters">
        <ul>
            <li>
                <a href="#"> Bộ Sản Phẩm</a>
                <ul class="dropdown" >
                    <c:forEach items="${CateProduct}" var="cp">
                        <li><a href="Categories?cateID=${cp.categoryId}">${cp.name}</a></li>
                    </c:forEach>
                </ul>
            </li>
            <li>
                <a href="#"> Kích Thước</a>
                <ul class="dropdown">
                    <c:forEach items="${SizeProduct}" var="sp">
                        <li><a href="Sizes?SizeRange=${sp.size}">${sp.size}</a></li>
<%--                        <li><a href="#">${sp.size}</a></li>--%>
                    </c:forEach>
                </ul>
            </li>
            <li>
                <a href="#"> Khoảng Giá</a>
                <ul class="dropdown">
                    <c:forEach items="${PriceProduct}" var="pp">
                        <li><a href="PriceRange?minPrice=${pp.priceMin}&maxPrice=${pp.priceMax}">${pp.priceMin} - ${pp.priceMax}</a></li>
<%--                        <li><a href="#">${pp.price}</a></li>--%>
                    </c:forEach>
                </ul>
            </li>
        </ul>
    </div>
    <div id="products" class="products">
        <!-- Sản phẩm -->
<%--        <c:forEach items="listProduct" var="p"></c:forEach> --%>
        <c:forEach items="${ProductControl}" var="p">
            <div class="product">
                <img src="${p.image}">
                <h2>${p.name}</h2>
                <p class="price">$${p.price}</p>
                <p class="description">${p.description}</p>
                <div class="product-buttons">
                    <button class="add-to-cart"><a href="">Thêm vào giỏ hàng</a></button>
                    <button class="view-details"><a href="ProductDetail?ProductID=${p.id}">Chi tiết</a></button>
                </div>
            </div>
        </c:forEach>
    </div>
</main>
<footer>
    <p>&copy; 2024 Sofa Shop. All rights reserved.</p>
</footer>
<!-- <script src="/js/scipt.js"></script> -->
<script src="./JSPWeb/js/scoller_header.js"></script>
<script src="./JSPWeb/dropdown.js"></script>
</body>

</html>