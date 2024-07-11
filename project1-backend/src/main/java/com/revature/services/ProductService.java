package com.revature.services;

import com.revature.model.Product;
import com.revature.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo pr;


}
