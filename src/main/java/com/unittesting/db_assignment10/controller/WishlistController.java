package com.unittesting.db_assignment10.controller;

import com.unittesting.db_assignment10.model.Wishlist;
import com.unittesting.db_assignment10.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WishlistController {
    @Autowired
    WishlistService wishlistService;

    @PostMapping("/wishlist/{id}")
    public Wishlist createWishlist(@RequestBody Wishlist wishlist, @PathVariable Integer id) {
        return wishlistService.createWishlist(wishlist, id);
    }

    @DeleteMapping("/wishlist/remove/{id}")
    public String removeWishlist(@PathVariable Integer id) {
        wishlistService.deleteWishlist(id);
        return "Deleted";
    }

    @GetMapping("/wishlist/view/{id}")
        public Wishlist getById(@PathVariable Integer id) {
            return wishlistService.getById(id);
        }

}
