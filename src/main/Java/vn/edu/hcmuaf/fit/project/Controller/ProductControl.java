package vn.edu.hcmuaf.fit.project.Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import vn.edu.hcmuaf.fit.project.DAO.model.PriceRange;
import vn.edu.hcmuaf.fit.project.DAO.model.Product;
import vn.edu.hcmuaf.fit.project.DAO.model.Sizes;
import vn.edu.hcmuaf.fit.project.DAO.model.categories;
import vn.edu.hcmuaf.fit.project.Service.PriceRangeService;
import vn.edu.hcmuaf.fit.project.Service.ProductService;
import vn.edu.hcmuaf.fit.project.Service.CategoryService;
import vn.edu.hcmuaf.fit.project.Service.SizeService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductControl", value = "/Products")
public class ProductControl extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all Product
        ProductService productService= new ProductService();
        List<Product> ProductData= null;
        try {
            ProductData = productService.getAll();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // get all Categories
        CategoryService categoryService = new CategoryService();
        List<categories> CategoryData= null;
        try {
            CategoryData = categoryService.getAll();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //get all Sizes
        SizeService sizeService = new SizeService();
        List<Sizes> SizeData= null;
        try {
            SizeData = sizeService.getAllSize();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //get all PriceRange
        PriceRangeService priceRangeService = new PriceRangeService();
        List<PriceRange> PriceRangeData = priceRangeService.getAllPriceRange();

        request.setAttribute("ProductControl",ProductData);
        request.setAttribute("CateProduct",CategoryData);
        request.setAttribute("SizeProduct",SizeData);
        request.setAttribute("PriceProduct", PriceRangeData);
        request.getRequestDispatcher("Product.jsp").forward(request,response);

//        ProductService productService = new ProductService();
//        int count = productService.countProduct();
//        int endPage = count/3;
//        if (count%3 != 0) {
//            endPage++;
//        }
//        request.setAttribute("endPage", endPage);
//        request.getRequestDispatcher("Product.jsp").forward(request, response);
//
//        // phan trang
//        String pageIndex = request.getParameter("pageIndex");
//        int index = Integer.parseInt(pageIndex);
//        List<Product> list = productService.PageProducts(index);
//        request.setAttribute("listP", list);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
