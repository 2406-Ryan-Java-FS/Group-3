package com.revature.services;

import java.util.List;

import com.revature.model.Cart;
import com.revature.model.Product;
import com.revature.model.User;
import com.revature.repositories.CartRepository;
import com.revature.repositories.ProductRepo;
import com.revature.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepo userRepository;

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
}
