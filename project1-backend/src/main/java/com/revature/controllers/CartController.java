package com.revature.controllers;

import java.util.List;
import java.util.Map;

import com.revature.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.services.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

  @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Map<String, Object> request) {
        Integer userId = Integer.parseInt(request.get("userId").toString());
        Integer productId = Integer.parseInt(request.get("productId").toString());
        Integer quantity = Integer.parseInt(request.get("quantity").toString());
        Cart cart = cartService.addToCart(userId, productId, quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Integer cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<Cart> updateCartItemQuantity(@PathVariable Integer cartItemId, @RequestBody Map<String, Object> request) {
        Integer quantity = Integer.parseInt(request.get("quantity").toString());
        Cart cart = cartService.updateCartItemQuantity(cartItemId, quantity);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Cart>> getCartItems(@RequestParam Integer userId) {
        List<Cart> cartItems = cartService.getCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }
}
