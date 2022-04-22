package com.unittesting.db_assignment10.controller;

import com.unittesting.db_assignment10.model.Product;
import com.unittesting.db_assignment10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/product/tocart/{id}")
    public Product addProductToCart(@RequestBody Product product, @PathVariable Integer id) {
        return productService.addProductToCart(product, id);
    }

    @PostMapping("/product/towishlist/{id}")
    public Product addProductToWishList(@RequestBody Product product, @PathVariable Integer id) {
        return productService.addProductToWishlist(product, id);
    }

    @DeleteMapping("/product/from-cart/{cartId}/{productId}")
    public String deleteProductFromCart(@PathVariable Integer cartId, @PathVariable Integer productId) {
        productService.deleteFromCart(cartId, productId);
        return "Deleted";
    }

    @DeleteMapping("/product/from-wishlist/{cartId}/{productId}")
    public String deleteProductFromWishlist(@PathVariable Integer cartId, @PathVariable Integer productId) {
        productService.deleteFromWishlist(cartId, productId);
        return "Deleted";
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @GetMapping("/products/all")
    public List<Product> getAll() {
        return productService.getAll();
    }
}
