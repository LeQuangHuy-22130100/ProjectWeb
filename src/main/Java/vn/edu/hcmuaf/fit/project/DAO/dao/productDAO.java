package vn.edu.hcmuaf.fit.project.DAO.dao;

import com.google.protobuf.Enum;
import lombok.SneakyThrows;
import vn.edu.hcmuaf.fit.project.DAO.db.DBConnect;
import vn.edu.hcmuaf.fit.project.DAO.model.Product;
import vn.edu.hcmuaf.fit.project.DAO.model.Sizes;
import vn.edu.hcmuaf.fit.project.DAO.model.categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class productDAO {
    List<Product> products = new ArrayList<>(); // Dùng cho danh sách
    Statement stmt;

    {
        try {
            stmt = DBConnect.get();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    ResultSet rs;

    public List<Product> getAll() throws SQLException, ClassNotFoundException {
        // Kết nối với database thông qua DBConnect
        rs = stmt.executeQuery(
                            "SELECT p.*, \n" +
                                    "       c.Name AS category_name, \n" +
                                    "       s.Size AS size_name\n" +
                                    "FROM product p\n" +
                                    "JOIN categories c ON p.CategoryID = c.CategoryID\n" +
                                    "JOIN sizes s ON p.SizeID = s.SizeID;"
        );

        // Duyệt qua từng dòng dữ liệu và thêm vào danh sách
        while (rs.next()) {
            Product product = new Product();
            categories category = new categories(rs.getInt("CategoryID"), rs.getString("Name"));
            product.setId(rs.getInt(1));
            product.setCategoryID(category);
            product.setName(rs.getString(3));
            product.setImage(rs.getString(4));
            product.setPrice(rs.getDouble(5));
            product.setDescription(rs.getString(6));
            product.setStock(rs.getInt(7));
            product.setMatarial(rs.getString(8));
            Sizes sizes = new Sizes(rs.getInt("SizeID"), rs.getString("size_name"));

            product.setSize(sizes);
            products.add(product);
        }
        rs.close();
        stmt.close();

        return products;
    }

    public Product getByID(String id) throws SQLException, ClassNotFoundException {
        String query =
                "SELECT p.*, \n" +
                        "c.Name AS category_name, \n" +
                        "s.Size AS size_name\n" +
                        "FROM product p\n" +
                "JOIN categories c ON p.CategoryId = c.CategoryId " +
                "JOIN sizes s ON p.SizeID = s.SizeID " +
                "WHERE p.ProductID = ?";

        Product product = null;
        try (
                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
//            pstmt.setInt(1, id);
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    product = new Product();
                    categories category = new categories(rs.getInt("CategoryID"), rs.getString("Name"));
                    product.setId(rs.getInt(1));
                    product.setCategoryID(category);
                    product.setName(rs.getString(3));
                    product.setImage(rs.getString(4));
                    product.setPrice(rs.getDouble(5));
                    product.setDescription(rs.getString(6));
                    product.setStock(rs.getInt(7));
                    product.setMatarial(rs.getString(8));
                    Sizes sizes = new Sizes(rs.getInt("SizeID"), rs.getString("size_name"));
                    product.setSize(sizes);
                }
            }
        }
        return product;

    }

    public List<Product> getListProductByCategoryID(String CategoryID) throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String query =
                "SELECT p.*, \n" +
                        "c.Name AS category_name, \n" +
                        "s.Size AS size_name\n" +
                        "FROM product p\n" +
                        "JOIN categories c ON p.CategoryId = c.CategoryId " +
                        "JOIN sizes s ON p.SizeID = s.SizeID " +
                "WHERE c.CategoryID = ?";

        try (
                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setString(1, CategoryID);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    categories category = new categories(rs.getInt("CategoryID"), rs.getString("Name"));
                    product.setId(rs.getInt(1));
                    product.setCategoryID(category);
                    product.setName(rs.getString(3));
                    product.setImage(rs.getString(4));
                    product.setPrice(rs.getDouble(5));
                    product.setDescription(rs.getString(6));
                    product.setStock(rs.getInt(7));
                    product.setMatarial(rs.getString(8));
                    Sizes sizes = new Sizes(rs.getInt("SizeID"), rs.getString("size_name"));
                    product.setSize(sizes);
                    products.add(product);
                }
                rs.close();
                stmt.close();
            }
        }
        return products;
    }

    public List<Product> getListProductBySize(String Size) throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String query =
                "SELECT product.*, categories.Name AS category_name, sizes.Size AS size_name " +
                        "FROM product " +
                        "JOIN categories ON product.CategoryID = categories.CategoryID " +
                        "JOIN sizes ON product.SizeID = sizes.SizeID " +
                        "WHERE sizes.Size = ?";
        try (
                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setString(1, Size);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    categories category = new categories(rs.getInt("CategoryID"), rs.getString("Name"));
                    product.setId(rs.getInt(1));
                    product.setCategoryID(category);
                    product.setName(rs.getString(3));
                    product.setImage(rs.getString(4));
                    product.setPrice(rs.getDouble(5));
                    product.setDescription(rs.getString(6));
                    product.setStock(rs.getInt(7));
                    product.setMatarial(rs.getString(8));
                    Sizes sizes = new Sizes(rs.getInt("SizeID"), rs.getString("size_name"));
                    product.setSize(sizes);
                    products.add(product);
                }
                rs.close();
                stmt.close();
            }
        }
        return products;
    }

    public List<Product> getListProductByPriceRange(String minPrice, String maxPrice) throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String query = null;
//        if (maxPrice == "trở lên"){
//            query =
//                    "SELECT p.*, \n" +
//                            "c.Name AS category_name, \n" +
//                            "s.Size AS size_name\n" +
//                            "FROM product p\n" +
//                            "JOIN categories c ON p.CategoryId = c.CategoryId " +
//                            "JOIN sizes s ON p.SizeID = s.SizeID " +
//                            "JOIN price_range pr ON p.PriceID = pr.PriceID " +
//                            "WHERE p.Price > ?";
//        }else {
//            query =
//                    "SELECT p.*, \n" +
//                            "c.Name AS category_name, \n" +
//                            "s.Size AS size_name\n" +
//                            "FROM product p\n" +
//                            "JOIN categories c ON p.CategoryId = c.CategoryId " +
//                            "JOIN sizes s ON p.SizeID = s.SizeID " +
//                            "JOIN price_range pr ON p.PriceID = pr.PriceID " +
//                            "WHERE p.Price BETWEEN ? AND ?";
//        }

        query =
                "SELECT p.*, \n" +
                        "c.Name AS category_name, \n" +
                        "s.Size AS size_name\n" +
                        "FROM product p\n" +
                        "JOIN categories c ON p.CategoryId = c.CategoryId " +
                        "JOIN sizes s ON p.SizeID = s.SizeID " +
                        "JOIN price_range pr ON p.PriceID = pr.PriceID " +
                        "WHERE pr.PriceMin >= ? AND (pr.PriceMax = 'trở lên' OR pr.PriceMax <= ?)";

        try (
                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setString(1, minPrice);

            if (!"trở lên".equalsIgnoreCase(maxPrice)) {
                pstmt.setString(2, maxPrice);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    categories category = new categories(rs.getInt("CategoryID"), rs.getString("Name"));
                    product.setId(rs.getInt(1));
                    product.setCategoryID(category);
                    product.setName(rs.getString(3));
                    product.setImage(rs.getString(4));
                    product.setPrice(rs.getDouble(5));
                    product.setDescription(rs.getString(6));
                    product.setStock(rs.getInt(7));
                    product.setMatarial(rs.getString(8));
                    Sizes sizes = new Sizes(rs.getInt("SizeID"), rs.getString("size_name"));
                    product.setSize(sizes);
                    products.add(product);
                }
                rs.close();
                stmt.close();
            }
        }
        return products;
    }

    //phaan trang
    @SneakyThrows
    public int countProduct() throws SQLException, ClassNotFoundException{
        String query = "SELECT COUNT(*) FROM product";
        try (
                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }

    // danh sach product theo trang
    public List<Product> PageProducts(int index) throws SQLException, ClassNotFoundException {
        int pageSize = 15;
        int offset = (index - 1) * pageSize;
        List<Product> products = new ArrayList<>();
        String query =
                        "SELECT *, sizes.Size\n" +
                                "FROM product\n" +
                                "JOIN sizes ON product.SizeID = sizes.SizeID\n"+
                                "LIMIT ? OFFSET ?";

        try (
                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, pageSize);
            pstmt.setInt(2, offset);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    categories category = new categories(rs.getInt("CategoryID"), rs.getString("Name"));
                    product.setId(rs.getInt(1));
                    product.setCategoryID(category);
                    product.setName(rs.getString(3));
                    product.setImage(rs.getString(4));
                    product.setPrice(rs.getDouble(5));
                    product.setDescription(rs.getString(6));
                    product.setStock(rs.getInt(7));
                    product.setMatarial(rs.getString(8));
                    Sizes sizes = new Sizes(rs.getInt("SizeID"), rs.getString("Size"));
                    product.setSize(sizes);
                    products.add(product);
                }
                rs.close();
                stmt.close();
            }
        }
        return products;
    }

    //sort product tang dan
    public List<Product> sortTang() throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT *, sizes.Size\n" +
                "FROM product\n" +
                "JOIN sizes ON product.SizeID = sizes.SizeID\n" +
                "ORDER BY product.Price ASC";
        try (
                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    categories category = new categories(rs.getInt("CategoryID"), rs.getString("Name"));
                    product.setId(rs.getInt(1));
                    product.setCategoryID(category);
                    product.setName(rs.getString(3));
                    product.setImage(rs.getString(4));
                    product.setPrice(rs.getDouble(5));
                    product.setDescription(rs.getString(6));
                    product.setStock(rs.getInt(7));
                    product.setMatarial(rs.getString(8));
                    Sizes sizes = new Sizes(rs.getInt("SizeID"), rs.getString("Size"));
                    product.setSize(sizes);
                    products.add(product);
                }
                rs.close();
                stmt.close();
            }
        }
        return products;
    }

    //sort product giam dan
    public List<Product> sortGiam() throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT *, sizes.Size\n" +
                "FROM product\n" +
                "JOIN sizes ON product.SizeID = sizes.SizeID\n" +
                "ORDER BY product.Price DESC;";
        try (
                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    categories category = new categories(rs.getInt("CategoryID"), rs.getString("Name"));
                    product.setId(rs.getInt(1));
                    product.setCategoryID(category);
                    product.setName(rs.getString(3));
                    product.setImage(rs.getString(4));
                    product.setPrice(rs.getDouble(5));
                    product.setDescription(rs.getString(6));
                    product.setStock(rs.getInt(7));
                    product.setMatarial(rs.getString(8));
                    Sizes sizes = new Sizes(rs.getInt("SizeID"), rs.getString("Size"));
                    product.setSize(sizes);
                    products.add(product);
                }
                rs.close();
                stmt.close();
            }
        }
        return products;
    }

    //findProductbyName
    public List<Product> findProductbyName(String name) throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT *, sizes.Size\n" +
                        "FROM Product\n" +
                        "JOIN sizes ON product.SizeID = sizes.SizeID\n" +
                        "WHERE Name LIKE ? COLLATE utf8mb4_general_ci;";
        try (

                Connection con = DBConnect.get().getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setString(1, "%" + name + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    categories category = new categories(rs.getInt("CategoryID"), rs.getString("Name"));
                    product.setId(rs.getInt(1));
                    product.setCategoryID(category);
                    product.setName(rs.getString(3));
                    product.setImage(rs.getString(4));
                    product.setPrice(rs.getDouble(5));
                    product.setDescription(rs.getString(6));
                    product.setStock(rs.getInt(7));
                    product.setMatarial(rs.getString(8));
                    Sizes sizes = new Sizes(rs.getInt("SizeID"), rs.getString("Size"));
                    product.setSize(sizes);
                    products.add(product);
                }
                rs.close();
                stmt.close();
            }
        }
        return products;
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        productDAO productDao = new productDAO();
//        List<Product> all = productDao.getAll();
//        for (Product productdata : all) {
//            System.out.println(productdata);
//            System.out.println("------------------------------------");
//        }
//        int count = productDao.countProduct();
//        System.out.println(count);

//        String name = "Sofa nhập khẩu Hưng Phát Sài Gòn";
        List<Product> all = productDao.PageProducts(1);
        for (Product productdata : all) {
            System.out.println(productdata);
            System.out.println("------------------------------------");
        }

//        Product findByID = productDao.getByID("1");
//        System.out.println(findByID);

//        List<Product> listByCateName = productDao.getListProductByCategory("Sofa Da");
//        for (Product listBycateName : listByCateName) {
//            System.out.println(listBycateName);
//            System.out.println("________");
//        }
//
//        System.out.println("________");
//        System.out.println("________");

//        String rangeSize = "Dưới 2,5m";
//        List<Product> listByProductSize = productDao.getListProductBySize(rangeSize);
//        for (Product listBySize : listByProductSize) {
//            System.out.println(listBySize);
//            System.out.println("________");
//        }
//        System.out.println("----------------------------------");

//        List<Product> listbyCateID = productDao.getListProductByCategoryID("1");
//            for (Product product : listbyCateID) {
//                System.out.println(product);
//                System.out.println("________");
//            }


//        System.out.println("________");
//        System.out.println("________");

//        List<Product> getProductByCategoryID = productDao.getListProductByCategoryID("1");
//        for (Product listByCateID : getProductByCategoryID) {
//            System.out.println(listByCateID);
//            System.out.println("________");
//        }

//        String min = "12000";
//        String max = "trở lên";
//        List<Product> getProductByPriceRange = productDao.getListProductByPriceRange(min,max);
//        for (Product PriceRangeList : getProductByPriceRange) {
//            System.out.println(PriceRangeList);
//        }
    }
}
