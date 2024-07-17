package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Cart;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.repository.CartRepository;
import com.revature.repository.ProductRepo;
import com.revature.repository.UserRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepo productRepository;

    public Cart addToCart(Integer userId, Integer productId, Integer quantity) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public void removeFromCart(Integer cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    public Cart updateCartItemQuantity(Integer cartItemId, Integer quantity) {
        Cart cart = cartRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public List<Cart> getCartItems(Integer userId) {
        return cartRepository.findByUser_UserId(userId);
    }

    public void clearCart(Integer userId) {
        cartRepository.deleteById(userId);
    }
}
