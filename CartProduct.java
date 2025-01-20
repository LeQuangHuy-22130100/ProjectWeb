package vn.edu.hcmuaf.fit.project.DAO.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartProduct implements java.io.Serializable {
    private int id;

    private String name;

    private double price;

    private String img;

    private int quantity;

    public CartProduct(int id, String name, double price, String img, int quantity) {
        this.id=id;
        this.name =name;
        this.price=price;
        this.img=img;
        this.quantity=quantity;
    }
    public CartProduct(

    ){}
}
