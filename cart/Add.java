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
import vn.edu.hcmuaf.fit.project.DAO.model.Product;
import vn.edu.hcmuaf.fit.project.Service.ProductService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Add", value = "/add-cart")
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService ps = new ProductService();
        Product pid = null;
        try {
            pid = ps.getProductDetail(request.getParameter("pid"));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(pid != null){
            response.sendRedirect("list-product?addCart=false");
        }
        HttpSession session = request.getSession(true);
        cartDAO c = (cartDAO) session.getAttribute("cart");
        if(c==null)
            c=new cartDAO();
        c.add(pid);
        session.setAttribute("cart",c);
        response.sendRedirect("list-product?addCart=ok");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}