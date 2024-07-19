package com.revature.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {}
