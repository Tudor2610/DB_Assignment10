package com.unittesting.db_assignment10.test;

import com.unittesting.db_assignment10.model.Cart;
import com.unittesting.db_assignment10.model.Product;
import com.unittesting.db_assignment10.model.User;
import com.unittesting.db_assignment10.service.CartService;
import com.unittesting.db_assignment10.service.ProductService;
import com.unittesting.db_assignment10.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Test
    public void whenCreateProduct_ThenProductTableSizeMustBeOne() {
        User user = new User();
        userService.createUser(user);

        Cart cart = new Cart();
        cartService.createCart(cart, user.getId());

        Product product = new Product();
        productService.addProductToCart(product, cart.getId());

        List<Product> productList = new ArrayList<>(productService.getAll());

        Assertions.assertEquals(1, productList.size());
    }
}
