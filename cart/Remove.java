package vn.edu.hcmuaf.fit.project.Controller.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.project.DAO.dao.cartDAO;

import java.io.IOException;

@WebServlet(name = "del", value = "/del-cart")
public class Remove extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int pid = -1;
    try {
        pid = Integer.parseInt(request.getParameter("pid"));
    } catch (NumberFormatException e) {
        response.sendRedirect("ShowCart");
    }
    HttpSession session = request.getSession(true);
    cartDAO c = (cartDAO) session.getAttribute("cart");
    if(c==null)
        c=new cartDAO();
    c.remove(pid);
    session.setAttribute("cart",c);
    response.sendRedirect("ShowCart");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}