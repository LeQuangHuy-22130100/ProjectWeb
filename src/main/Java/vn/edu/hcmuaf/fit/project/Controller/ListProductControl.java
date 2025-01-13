package vn.edu.hcmuaf.fit.project.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import vn.edu.hcmuaf.fit.project.Service.ProductService;

import java.io.IOException;

@WebServlet(name = "ListProductControl", value = "/ListProduct")
public class ListProductControl extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();
        int count = productService.countProduct();
        int endPage = count/15;
        if (endPage!=0) {
            endPage++;
        }
        request.setAttribute("endPage", endPage);
        request.getRequestDispatcher("Product.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
