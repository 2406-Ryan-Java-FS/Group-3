package com.revature.services;

import com.revature.model.Category;
import com.revature.model.Product;
import com.revature.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

//    @Autowired
    CategoryRepo cr;

    @Autowired
    public CategoryService (CategoryRepo cr) {
        this.cr = cr;
    }

    public List<Category> getAllCategories() {
        return cr.findAll();
    }

    public Category getCategoryById(int id) {
        return cr.findById(id).orElseGet(Category::new);
    }

    public Category addCategory(Category c) {
        return cr.save(c);
    }

    public Category updateCategory(Category update) {
        return cr.save(update);
    }

    public boolean deleteCategory(int id) {
        try {
            cr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
