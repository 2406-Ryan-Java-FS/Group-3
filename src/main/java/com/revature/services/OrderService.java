package com.revature.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Orders;
import com.revature.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Optional<Orders> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

   public List<Orders> getOrdersByUserId(Integer userId) {
        return orderRepository.findByUser_UserId(userId);
    }

    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }

    public Orders updateOrder(Integer id, Orders orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setStatus(orderDetails.getStatus());
                    order.setUpdatedAt(new Date());
                    return orderRepository.save(order);
                }).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public Orders updateOrderStatus(Integer id, String status) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setStatus(status);
                    order.setUpdatedAt(new Date());
                    return orderRepository.save(order);
                }).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    public String getOrderStatus(Integer id) {
        return orderRepository.findById(id)
                .map(Orders::getStatus)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }
    
    public Orders applyDiscount(Integer orderId, String discountCode) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    
                    if ("DISCOUNT10".equals(discountCode)) {
                        double discount = order.getTotalAmount() * 0.10;
                        order.setTotalAmount(order.getTotalAmount() - discount);
                    }
                    return orderRepository.save(order);
                }).orElseThrow(() -> new RuntimeException("Order not found with id " + orderId));
    }
    
   /* public Orders checkout(Integer userId) {
        // Logic to handle checkout process
        Orders order = new Orders();
        order.setUser(userId);
        order.setStatus("CHECKED_OUT");
        order.setCreatedAt(new Date());
        order.setUpdatedAt(new Date());
        // Save order to the repository
        return orderRepository.save(order);
    }*/
    
    public Orders getOrderSummary(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + orderId));
    }
    
    public Map<String, Double> calculateTotalCostIncludingTaxesAndShipping(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    Map<String, Double> totalDetails = new HashMap<>();
                    Double totalAmount = order.getTotalAmount();
                    if (totalAmount == null) {
                        totalAmount = 0.0; // Default to 0 if totalAmount is null. Alternatively, throw an exception if this is unexpected.
                        // throw new RuntimeException("Total amount is not set for order with id " + orderId);
                    }
                    double taxes = totalAmount * 0.10; // Assuming 10% tax
                    double shipping = 50.0; // Flat rate shipping fee
                    totalDetails.put("Total Amount", totalAmount);
                    totalDetails.put("Taxes", taxes);
                    totalDetails.put("Shipping", shipping);
                    totalDetails.put("Final Total", totalAmount + taxes + shipping);
                    return totalDetails;
                }).orElseThrow(() -> new RuntimeException("Order not found with id " + orderId));
    }
}
