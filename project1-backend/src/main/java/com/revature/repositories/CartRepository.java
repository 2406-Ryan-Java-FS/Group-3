package com.revature.repositories;

import com.revature.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUser_UserId(Integer userId);
    void deleteByUser_UserIdAndProduct_Id(Integer userId, Integer productId);
}
