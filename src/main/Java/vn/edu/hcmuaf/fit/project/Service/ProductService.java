package vn.edu.hcmuaf.fit.project.Service;
import vn.edu.hcmuaf.fit.project.DAO.dao.productDAO;
import vn.edu.hcmuaf.fit.project.DAO.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    productDAO productDao= new productDAO();

    public List<Product> getAll() throws SQLException, ClassNotFoundException {
        return productDao.getAll();
    }

    public Product getProductDetail(String id) throws SQLException, ClassNotFoundException {
        return productDao.getByID(id);
    }

    public List<Product> getProductbyCateID(String cateID) throws SQLException, ClassNotFoundException {
        return productDao.getListProductByCategoryID(cateID);
    }

    public List<Product> listSizeRange(String SizeRange) throws SQLException, ClassNotFoundException {
        return productDao.getListProductBySize(SizeRange);
    }

    public List<Product> getProductByPriceRange(String min, String max) throws SQLException, ClassNotFoundException{
        return productDao.getListProductByPriceRange(min, max);
    }

    public Product findById(String id) throws SQLException, ClassNotFoundException {
        return productDao.getByID(id);
    }


    // phan trang Product
    public int countProduct() throws SQLException, ClassNotFoundException {
        return productDao.countProduct();
    }

    public List<Product> PageProducts(int index) throws SQLException, ClassNotFoundException {
        return productDao.PageProducts(index);
    }


    // Phan trang category
    public int countProductCategory(int sizeID) throws SQLException, ClassNotFoundException {
        return productDao.countProductCategory(sizeID);
    }
    public List<Product> PageProductCategory(String CategoryID, int page) throws SQLException, ClassNotFoundException {
        return productDao.PageProductsCategoryID(CategoryID,page);
    }
    public List<Product> PageProductsPriceRange(String minPrice, String maxPrice, int index) throws SQLException, ClassNotFoundException {
        return productDao.PageProductsPriceRange(minPrice, maxPrice, index);
    }
    public List<Product> PageProductsSize(String sizeID, int page) throws SQLException, ClassNotFoundException {
        return productDao.PageProductsSize(sizeID,page);
    }

    //phan trang price
    public int countProductPriceRange(int min , int max) throws SQLException, ClassNotFoundException {
        return productDao.countProductPriceRange(min,max);
    }

    //phan trang size
    public int countProductSize(int sizeID) throws SQLException, ClassNotFoundException {
        return productDao.countProductSize(sizeID);
    }

    //sort product
    public List<Product> sortTang() throws SQLException, ClassNotFoundException {
        return productDao.sortTang();
    }

    public List<Product> sortGiam() throws SQLException, ClassNotFoundException {
        return productDao.sortGiam();
    }

    //tim product theo ten
    public List<Product> findProductByName(String keyword) throws SQLException, ClassNotFoundException {
        return productDao.findProductbyName(keyword);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ProductService productService = new ProductService();
//        String sizeRange = "Dưới 2,5m";
////        List<Product> list = productService.getProductbyCateID("1");
//        List<Product> list = productService.listSizeRange(sizeRange);
//        System.out.println(list);
//        System.out.println();
//
//        ProductService productService = new ProductService();
//        String min = "12000";
//        String max = "trở lên";
//        List<Product> getProductByPriceRange = productService.PageProducts(1);
//        for (Product PriceRangeList : getProductByPriceRange) {
//            System.out.println(PriceRangeList);
//        }
    }
}
