package vn.edu.hcmuaf.fit.project.Controller.AdminPage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import vn.edu.hcmuaf.fit.project.DAO.model.Product;
import vn.edu.hcmuaf.fit.project.Service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductManagement", value = "/productManagement")
public class productManagerment extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        List<Product> productManagement = productService.getAll();
        req.setAttribute("productManagement", productManagement);
        req.getRequestDispatcher("ProductManagement.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
