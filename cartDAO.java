package vn.edu.hcmuaf.fit.project.DAO.dao;

import vn.edu.hcmuaf.fit.project.DAO.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class cartDAO {
    Map<Integer, CartProduct> data= new HashMap<>();
    public boolean add(Product p){
    if(data.containsKey(p.getId())){
        return update(p.getId(),data.get(p.getId()).getQuantity()+1);
    }
    data.put(p.getId(),convert(p));

    return true;
    }
    public boolean update(int id,int quantity){
        Product p;
        if(data.containsKey(id)){
            CartProduct cp = data.get(id);
            cp.setQuantity(quantity);
            data.put(cp.getId(),cp);
            return true;
        }
        return false;
    }
    public boolean remove(int id){
        return data.remove(id)!=null;
    }
    public List<CartProduct>list(){
        return new ArrayList<>(data.values());
    }
    public int getTotalQuantity(){
        AtomicInteger i = new AtomicInteger();
        data.values().forEach(cp->{
            i.addAndGet(cp.getQuantity());
        });
        return i.get();
    }
    public double getTotalPrice(){
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        data.values().forEach(cp->{
            total.updateAndGet(v -> new Double((double) (v + cp.getPrice() * cp.getQuantity())));
        });
        return total.get();
    }
    private CartProduct convert (Product p){
        CartProduct cp = new CartProduct();
        cp.setId(p.getId());
        cp.setName(p.getName());
        cp.setPrice(p.getPrice());
        cp.setQuantity(1);
        return cp;
    }
}
