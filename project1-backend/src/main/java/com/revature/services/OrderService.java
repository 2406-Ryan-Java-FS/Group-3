package com.revature.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Address;
import com.revature.model.Order;
import com.revature.model.OrderItem;
import com.revature.model.User;
import com.revature.repositories.AddressRepo;
import com.revature.repositories.OrderItemRepo;
import com.revature.repositories.OrderRepo;
import com.revature.repositories.UserRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    private OrderItemRepo orderItemRepo;
    
    @Autowired
    private AddressRepo addressRepo;
    
    @Autowired
    private UserRepo userRepo;

    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrderByUserId(Integer userId) {
        return orderRepository.findByUser_UserId(userId);
    }

    public Order createOrder(Order order) {
        User user = userRepo.findById(order.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + order.getUser().getUserId()));
        
        Address address = addressRepo.findById(order.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found with id " + order.getAddressId()));
        
        order.setUser(user);
        order.setAddressId(user.getUserId());
        order.setCreatedAt(new Date());
        order.setUpdatedAt(new Date());
        return orderRepository.save(order);
    }


    public Order updateOrder(Integer id, Order orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setStatus(orderDetails.getStatus());
                    order.setAddressId(orderDetails.getAddressId());
                    order.setUpdatedAt(new Date());
                    return orderRepository.save(order);
                }).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrderStatus(Integer id, String status) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setStatus(status);
                    order.setUpdatedAt(new Date());
                    return orderRepository.save(order);
                }).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    public String getOrderStatus(Integer id) {
        return orderRepository.findById(id)
                .map(Order::getStatus)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    public Order applyDiscount(Integer orderId, String discountCode) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    calculateOrderTotalAmount(order);

                    if ("DISCOUNT10".equals(discountCode)) {
                        double discount = order.getTotalAmount() * 0.10;
                        order.setTotalAmount(order.getTotalAmount() - discount);
                    }
                    return orderRepository.save(order);
                }).orElseThrow(() -> new RuntimeException("Order not found with id " + orderId));
    }

    public Order getOrderSummary(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + orderId));
    }

    public Map<String, Double> calculateTotalCostIncludingTaxesAndShipping(Integer orderId) {
        return orderRepository.findById(orderId)
            .map(order -> {
                calculateOrderTotalAmount(order);

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

    public void calculateOrderTotalAmount(Order order) {
        List<OrderItem> orderItems = orderItemRepo.findByOrderId(order);
        double totalAmount = orderItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        order.setTotalAmount(totalAmount);
    }
}
