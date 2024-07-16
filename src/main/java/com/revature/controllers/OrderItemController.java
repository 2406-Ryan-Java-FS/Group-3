package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.OrderItem;
import com.revature.repository.OrderItemRepository;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Integer id) {
        return orderItemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Integer orderId) {
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderId);
        return ResponseEntity.ok(orderItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Integer id, @RequestBody OrderItem orderItem) {
        if (!orderItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderItem.setId(id);
        OrderItem updatedOrderItem = orderItemRepository.save(orderItem);
        return ResponseEntity.ok(updatedOrderItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Integer id) {
        if (!orderItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }}
