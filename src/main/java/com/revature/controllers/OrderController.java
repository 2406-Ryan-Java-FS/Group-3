package com.revature.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Orders;
import com.revature.services.CartService;
import com.revature.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Orders>> getOrdersByUserId(@PathVariable Integer userId) {
        List<Orders> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Integer orderId, @RequestBody Orders orderDetails) {
        return ResponseEntity.ok(orderService.updateOrder(orderId, orderDetails));
    }

   /* @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
*/
    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Orders> updateOrderStatus(@PathVariable Integer orderId, @RequestBody Map<String, String> request) {
        String status = request.get("status");
        Orders updatedOrder = orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok(updatedOrder);
    }

    @GetMapping("/{orderId}/status")
    public ResponseEntity<String> getOrderStatus(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.getOrderStatus(orderId));
    }
    
    @PostMapping("/{orderId}/applyDiscount")
    public ResponseEntity<Orders> applyDiscount(@PathVariable Integer orderId, @RequestBody Map<String, String> request) {
        String discountCode = request.get("discountCode");
        Orders updatedOrder = orderService.applyDiscount(orderId, discountCode);
        return ResponseEntity.ok(updatedOrder);
    }
    
    /*  public Map<String, Double> calculateTotal(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    Map<String, Double> totalDetails = new HashMap<>();
                    double totalAmount = order.getTotalAmount();
                    double taxes = totalAmount * 0.10; // 10% tax
                    double shipping = 50.0; // Flat rate shipping fee
                    totalDetails.put("Total Amount", totalAmount);
                    totalDetails.put("Taxes", taxes);
                    totalDetails.put("Shipping", shipping);
                    totalDetails.put("Final Total", totalAmount + taxes + shipping);
                    return totalDetails;
                }).orElseThrow(() -> new RuntimeException("Order not found with id " + orderId));
    }
    


    @GetMapping("/order/{orderId}/summary")
    public ResponseEntity<Orders> getOrderSummary(@PathVariable Integer orderId) {
        Orders orderSummary = orderService.getOrderSummary(orderId);
        return ResponseEntity.ok(orderSummary);
    }*/
    
    @GetMapping("/order/{orderId}/summary")
    public ResponseEntity<Orders> getOrderSummary(@PathVariable Integer orderId) {
        Orders orderSummary = orderService.getOrderSummary(orderId);
        return ResponseEntity.ok(orderSummary);
    }
    
    @GetMapping("/{orderId}/calculateTotal")
    public ResponseEntity<Map<String, Double>> calculateTotal(@PathVariable Integer orderId) {
        Map<String, Double> totalDetails = orderService.calculateTotalCostIncludingTaxesAndShipping(orderId);
        return ResponseEntity.ok(totalDetails);
    }
}

