package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.model.Product;
import DAO.model.Sizes;
import DAO.model.categories;

@WebServlet("/product_list")
public final class ProductListControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PAGE_SIZE = 12; // Thay đổi số sản phẩm mỗi trang thành 12 để grid đẹp hơn
    private static final int DEFAULT_PAGE = 1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            // Đặt character encoding
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            
            // Lấy trang hiện tại với xử lý lỗi tốt hơn
            int page = getPageNumber(request);
            
            // Tạo danh sách sản phẩm mẫu
            List<Product> products = createSampleProducts();
            
            // Tính toán phân trang
            int totalProducts = products.size();
            int totalPages = (int) Math.ceil((double) totalProducts / DEFAULT_PAGE_SIZE);
            
            // Đảm bảo page không vượt quá totalPages
            page = Math.min(page, totalPages);
            page = Math.max(1, page);
            
            // Tính start và end index
            int start = (page - 1) * DEFAULT_PAGE_SIZE;
            int end = Math.min(start + DEFAULT_PAGE_SIZE, totalProducts);
            
            // Lấy sản phẩm cho trang hiện tại
            List<Product> paginatedProducts = products.subList(start, end);
            
            // Set attributes
            request.setAttribute("productList", paginatedProducts);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);
            
            // Forward to JSP
            request.getRequestDispatcher("product_list.jsp").forward(request, response);
            
        } catch (Exception e) {
            // Log error và chuyển hướng đến trang lỗi nếu cần
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    private int getPageNumber(HttpServletRequest request) {
        String pageParam = request.getParameter("page");
        if (pageParam == null || pageParam.isEmpty()) {
            return DEFAULT_PAGE;
        }
        try {
            return Integer.parseInt(pageParam);
        } catch (NumberFormatException e) {
            return DEFAULT_PAGE;
        }
    }
    
    private List<Product> createSampleProducts() {
        List<Product> products = new ArrayList<>();
        categories defaultCategory = new categories();
        Sizes defaultSize = new Sizes();
        
        for (int i = 1; i <= 100; i++) {
            products.add(new Product(
                i,                          // id
                defaultCategory,            // categoryID
                "Sản phẩm " + i,           // name
                "sofa" + i + ".jpg",       // image
                i * 10000.0,               // price
                "Mô tả sản phẩm " + i,     // description
                10,                        // stock
                "Material " + i,           // material
                defaultSize                // sizeID
            ));
        }
        return products;
    }
}
