package com.unittesting.db_assignment10.test;

import com.unittesting.db_assignment10.model.Cart;
import com.unittesting.db_assignment10.model.User;
import com.unittesting.db_assignment10.service.CartService;
import com.unittesting.db_assignment10.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Test
    public void whenCreateCart_ThenCartTableSizeMustBeOne() {
        User user = new User();
        userService.createUser(user);

        Cart cart = new Cart();
        cartService.createCart(cart, user.getId());

        List<Cart> cartList = new ArrayList<>();
        cartList.addAll(userService.getUserById(user.getId()).getCart());

        Assertions.assertEquals(1, cartList.size());
    }
}
