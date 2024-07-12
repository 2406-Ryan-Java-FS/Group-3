package com.revature.controllers;

import com.revature.model.Category;
import com.revature.model.Product;
import com.revature.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categories")
@RestController
public class CategoryController {

    CategoryService cs;

    @Autowired
    public CategoryController(CategoryService cs) {
        this.cs = cs;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return cs.getAllCategories();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> addCategory(@RequestBody Category c) {
        c = cs.addCategory(c);

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateItem(@PathVariable int id, @RequestBody Category c) {
        c.setId(id);
        Category c2 = cs.getCategoryById(id);
        if(c2.getId() == id) {
            c = cs.updateCategory(c);
            return new ResponseEntity<>(c,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable int id) {
        boolean wasDeleted = cs.deleteCategory(id);
        return new ResponseEntity<>(wasDeleted? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
