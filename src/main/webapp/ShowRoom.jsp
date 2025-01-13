<%--
  Created by IntelliJ IDEA.
  User: zenry
  Date: 23/12/2024
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./JSPWeb/CSS/CSS_Showroom.css">

</head>

<body>
<div class="img_Background">
    <img src="./JSPWeb/IMG/9333e5e69a6da08cf73cb50419f68a1f.jpg" alt="">
</div>

<header class="header_home_menu">
    <img src="./JSPWeb/IMG/logo.jpg" alt="" width="50">
    <ul class="menu">
        <li>
            <a href="HomePage">
                <span class="text_header"> TRANG CHỦ</span>
            </a>
        </li>
        <li>
            <a href="Products">
                <span class="text_header"> SẢN PHẨM</span>
            </a>
        </li>
        <li>
            <a href="#">
                <span class="text_header"> SHOWROOM</span>
            </a>
        </li>
        <li>
            <a href="contactUs">
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
        <li>
            <i class="fa-solid fa-heart" style="color: #ffffff;"></i>
        </li>
        <li>
            <a href="CartShopping">
                <i class="fas fa-shopping-cart"></i>
            </a>
        </li>
    </ul>
</header>

<div class="layer2">
    <h2>SHOWROOM NỘI THẤT SOFA</h2>
</div>

<div class="layer3">
    <div class="text">
        <h3>SHOWROOM NỘI THẤT HỒ CHÍ MINH</h3> <br>
        <h4>Địa Chỉ: Số 69 - 71 Nguyễn Cơ Thạch, Khu đô thị Sala, P. An Lợi Đông, Q. 2, HCM</h4><br>
        <h4>Hotline: 0948426006 - Tổng đài CSKH: 1800 6398</h4> <br>
        <p>Nằm ngay trên đại lộ Đông - Tây của thành phố, thuộc khu phố sầm uất mới nổi ở quận 2 - showroom
            Kenli nổi bật trong khu đô thị Sala. <br>

            Với thiết kế 5 tầng riêng biệt và được bài trí theo từng concept khác nhau đầy cuốn hút. Gian phòng
            Milano&Design ấn tượng với những gam màu nổi bật như cam, trắng, nâu... Chateau d'Ax sang trọng với
            gam màu tối đơn giản đậm chất Ý hay Magis đầy nghệ thuật với những sản phẩm như những bức tranh về
            cuộc sống. <br>

            Đến với showroom Kenli, bạn sẽ được trải nghiệm những sản phẩm nội thất hàng đầu thế giới và đắm
            chìm, mãn nhãn trước những tuyệt tác tới từ nước Ý. <br></p>
    </div>
    <div class="ggMap">
        <img src="./JSPWeb/IMG/ggMap1.jpg.png" alt="">
    </div>
</div>
<div class="layer4">
    <div class="text">
        <h3>ĐẠI LÝ BÌNH DƯƠNG</h3> <br>
        <h4>Địa Chỉ: Số 5/20 Đại lộ Bình Dương - KP.Hòa Lân 1 - P.Thuận Giao - TP. Thuận An - Bình Dương</h4><br>
        <h4>Hotline: 0918 352 375</h4> <br>
        <p>Nội thất Kenli Bình Dương - Đại lý phân phối chính thức của Nội thất Kenli. Tại đây, chúng tôi cung cấp
            đa dạng các sản phẩm nội thất cao cấp nhập khẩu châu Âu bao gồm các mẫu sofa da thật chuẩn Ý - nhập khẩu
            nguyên chiếc đến từ thương hiệu Milano & Design - Thương hiệu trực thuộc Tập đoàn sofa da thật lớn nhất
            châu Âu Chateau d’Ax, bàn ghế ăn, giường ngủ,... và cung cấp chính sách bảo hành, bảo dưỡng định kỳ cho
            khách hàng sở hữu sản phẩm. <br></p>
    </div>
    <div class="ggMap">
        <img src="./JSPWeb/IMG/ggMap2.jpg.png" alt="">
    </div>
</div>
<div class="layer5">
    <div class="text">
        <h3>SHOWROOM QUẢNG NINH</h3> <br>
        <h4>Địa Chỉ: Số 66, đường 25 tháng 4, phường Bạch Đằng, TP Hạ Long, tỉnh Quảng Ninh</h4><br>
        <h4>Hotline: 0988 855 874 - 0904 326 356</h4> <br>
        <p>Từ ngày 20/10/2018, Nội thất Kenli Quảng Ninh chính thức ra đời với sứ mệnh phụng sự giới tinh hoa Đất
            Mỏ, đem đến những sản phẩm cao cấp nhất, dẫn lối nghệ thuật vào các dinh thự xa hoa tại đây. Từ đó,
            không chỉ song hành cùng quá trình phát triển của “Thủ phủ vàng đen”, mà còn giúp tiết kiệm quỹ thời
            gian quý báu của giới thượng lưu Quảng Ninh khi tìm mua nội thất cao cấp.<br></p>
    </div>
    <div class="ggMap">
        <img src="./JSPWeb/IMG/ggMap3.png" alt="">
    </div>
</div>

<footer id="footer_pages" class="footer" style="width: 100%; color: black;">
    <div class="showroom_footer">
        <h2>SHOWROOM</h2>
        <ul>
            <li>Trụ sở & Showroom 1: Tòa nhà Kenli, Số 2 Dịch Vọng Hậu, Q. Cầu Giấy</li>
            <li>Showroom 2: Số 4 Dịch Vọng Hậu, Q. Cầu Giấy</li>
            <li>Trụ sở & Showroom: 69 - 71 Nguyễn Cơ Thạch, Khu đô thị Sala, An Lợi Đông, Quận 2</li>
            <li>Email: xxxxxxx@gmail.com</li>
            <li>Thời gian làm việc : T2 - CN 8h30 - 22h</li>
        </ul>
    </div>

    <div class="suport_footter">
        <h2>HỖ TRỢ KHÁCH HÀNG</h2>
        <ul>
            <li>Hướng Dẫn Mua Hàng</li>
            <li>Chính Sách Bảo Mật</li>
            <li>Chính Sách Đổi Trả Hàng</li>
            <li>Phương Thức Thanh Toán</li>
            <li>Vận Chuyển Lắp Đặt</li>
            <li>Dịch Vụ Bảo Hành</li>
        </ul>
    </div>

    <div class="follow_footer">
        <h2>LIÊN HỆ - THEO DÕI</h2>
        <div class="icon_footer">
            <i class="fa-brands fa-facebook" style="color: #005eff;  font-size: 30px;"></i>
            <i class="fa-brands fa-twitter" style="color: #005eff; font-size: 30px"></i>
            <i class="fa-brands fa-instagram" style="color: #fb1818; font-size: 30px"></i>
        </div>
    </div>
</footer>


<script src="./JSPWeb/js/scoller_header.js"></script>
</body>

</html>
