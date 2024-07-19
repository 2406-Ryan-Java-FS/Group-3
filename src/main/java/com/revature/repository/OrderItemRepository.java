package com.revature.repository;

import com.revature.models.OrderItem;
import com.revature.models.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	List<OrderItem> findByOrderId(Integer orderId);
}
