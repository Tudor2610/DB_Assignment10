package com.unittesting.db_assignment10.test;

import com.unittesting.db_assignment10.model.User;
import com.unittesting.db_assignment10.model.Wishlist;
import com.unittesting.db_assignment10.service.UserService;
import com.unittesting.db_assignment10.service.WishlistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class WishlistServiceTest {
    @Autowired
    WishlistService wishlistService;

    @Autowired
    UserService userService;

    @Test
    public void whenCreateWishlist_ThenWishlistTableSizeMustBeOne() {
        User user = new User();
        userService.createUser(user);

        Wishlist wishlist = new Wishlist();
        wishlistService.createWishlist(wishlist, user.getId());

        List<Wishlist> wishlistList = new ArrayList<>();
        wishlistList.add(userService.getUserById(user.getId()).getWishlist());

        Assertions.assertEquals(1, wishlistList.size());
    }
}
