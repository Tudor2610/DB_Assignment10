package com.unittesting.db_assignment10.controller;

import com.unittesting.db_assignment10.model.Cart;
import com.unittesting.db_assignment10.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/cart/{id}")
    public Cart createCart(@RequestBody Cart cart, @PathVariable Integer id) {
        return cartService.createCart(cart, id);
    }

    @DeleteMapping("/cart/remove/{userId}/{cartId}")
    public String deleteCart(@PathVariable Integer userId, @PathVariable Integer cartId) {
        cartService.deleteCart(userId, cartId);
        return "Deleted!";
    }

    @GetMapping("/cart/{id}")
    public Cart getCartById(@PathVariable Integer id) {
        return cartService.getById(id);
    }

    @GetMapping("/carts/view")
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @GetMapping("/carts/filtered")
    public List<Cart> getFilteredCarts() {
        return cartService.filterByQuantity();
    }
}
