package vn.edu.hcmuaf.fit.project.DAO.model;

public class cartShopping {
    private int cartId;
    private Product productID;
    private User userID;
    private double quantity;
    private String name;
    private String image;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "cartShopping{" +
                "cartId=" + cartId +
                ", productID=" + productID +
                ", userID=" + userID +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
