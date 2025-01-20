package vn.edu.hcmuaf.fit.project.Controller.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.project.DAO.dao.cartDAO;
import vn.edu.hcmuaf.fit.project.DAO.model.CartItem;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowCart", value = "/ShowCart")
public class ShowCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        cartDAO cart = (cartDAO) session.getAttribute("cart");

        if (cart == null) {
            cart = new cartDAO();
            session.setAttribute("cart", cart);
        }

        request.setAttribute("cart", cart);

        request.getRequestDispatcher("views/cart/show-cart.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}