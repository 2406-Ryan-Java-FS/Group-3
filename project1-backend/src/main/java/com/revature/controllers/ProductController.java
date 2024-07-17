package com.revature.controllers;

import com.revature.model.Product;
import com.revature.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

//    @Autowired
    ProductService ps;

    @Autowired
    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return ps.getAllProducts();
    }

    @GetMapping("/{id}")
    public  Product getProduct(@PathVariable int id) {
        return ps.getProductById(id);
    }

    @GetMapping("/search")
    public List<Product> getProductByName(@RequestParam String name) {
        return ps.getProductByName(name);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> addProduct(@RequestBody Product p) {
        p = ps.addProduct(p);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateItem(@PathVariable int id, @RequestBody Product p) {
        p.setId(id);
        Product p2 = ps.getProductById(id);
        if(p2.getId() == id) {
            p = ps.updateProduct(p);
            return new ResponseEntity<>(p,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable int id) {
        boolean wasDeleted = ps.deleteProduct(id);
        return new ResponseEntity<>(wasDeleted? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }

}
