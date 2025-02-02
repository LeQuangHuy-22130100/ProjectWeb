<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zenry
  Date: 23/12/2024
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="vn.edu.hcmuaf.fit.project.DAO.model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="vn.edu.hcmuaf.fit.project.DAO.dao.CartProduct" %>

<%
    HttpSession sessionObj = request.getSession();
    List<CartItem> cart = (List<CartItem>) sessionObj.getAttribute("cart");
    User currentUser = (User) sessionObj.getAttribute("user");

    double totalAmount = 0;
    double taxes = 4.82; // Giả định thuế cố định
    double shippingFee = 0; // Miễn phí vận chuyển

    DecimalFormat df = new DecimalFormat("#,##0.00");

    if (cart == null || cart.isEmpty()) {
        response.sendRedirect("CartShopping.jsp"); // Nếu giỏ hàng trống, quay về trang giỏ hàng
        return;
    }

    for (CartItem item : cart) {
        totalAmount += item.getProductID().getPrice() * item.getQuantity();
    }

    double finalAmount = totalAmount + taxes + shippingFee;
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout - My Store</title>
    <link rel="stylesheet" href="./JSPWeb/CSS/CheckOutCSS.css">
</head>
<body>

<div class="checkout-container">
    <h2>My Store Ltd.</h2>
    <a href="CartShopping.jsp" class="back-link">&lt; Back to merchant’s site</a>

    <div class="checkout-content">
        <!-- Cột bên trái: Phương thức thanh toán -->
        <div class="payment-methods">
            <h3>How would you like to pay?</h3>
            <div class="payment-options">
                <img src="./JSPWeb/IMG/visa.png" alt="Visa">
                <img src="./JSPWeb/IMG/mastercard.png" alt="MasterCard">
                <img src="./JSPWeb/IMG/paypal.png" alt="PayPal">

            </div>
        </div>

        <!-- Cột bên phải: Tóm tắt đơn hàng -->
        <div class="order-summary">
            <h3>Order Summary</h3>
            <p>Order reference: <strong>123456</strong></p>

            <ul>
                <% for (CartItem item : cart) { %>
                <li>
                    <span><%= item.getProductID().getName() %> (x<%= item.getQuantity() %>)</span>
                    <span>€<%= df.format(item.getProductID().getPrice() * item.getQuantity()) %></span>
                </li>
                <% } %>
            </ul>

            <p>Shipping: <strong>Free</strong></p>
            <p>Taxes: <strong>€<%= df.format(taxes) %></strong></p>
            <p>Total: <strong>€<%= df.format(finalAmount) %></strong></p>

            <form action="PaymentServlet" method="post">
                <input type="hidden" name="totalAmount" value="<%= finalAmount %>">
                <button type="submit" class="btn-pay">Continue to secure payment</button>
            </form>
            <a href="CartShopping.jsp" class="btn-cancel">Cancel payment</a>
        </div>
    </div>

    <footer>
        <p>Payment processed by <strong>ingenico ePayments</strong></p>
        <a href="#">About Ingenico</a> | <a href="#">Privacy Policy</a> | <a href="#">Security</a> | <a href="#">Legal Info</a>
    </footer>
</div>

</body>
</html>
