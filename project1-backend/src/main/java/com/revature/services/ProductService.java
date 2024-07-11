package com.revature.services;

import com.revature.model.Product;
import com.revature.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo pr;

//    @Autowired
//    public  ProductService(ProductRepo pr) {
//        this.pr = pr;
//    }

    public List<Product> getAllProducts() {
        return pr.findAll();
    }

    public Product getProductById(Long id) {
        return pr.findById(Math.toIntExact(id)).orElseGet(Product::new);
    }

    public Product addProduct(Product p) {
        return pr.save(p);
    }

    public Product updateProduct(Product update) {
        return pr.save(update);
    }

    public boolean deleteProduct(Long id) {
        try {
            pr.deleteById(Math.toIntExact(id));
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

}
