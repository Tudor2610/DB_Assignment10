package com.unittesting.db_assignment10.service;

import com.unittesting.db_assignment10.model.Wishlist;
import com.unittesting.db_assignment10.repository.UserRepository;
import com.unittesting.db_assignment10.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class WishlistService {
    @Autowired
    WishlistRepository wishlistRepository;
    @Autowired
    UserRepository userRepository;

    public Wishlist createWishlist(Wishlist wishlist, Integer id) {
        userRepository.getById(id).setWishlist(wishlist);
        return wishlistRepository.save(wishlist);
    }

    public void deleteWishlist(Integer id) {
        userRepository.getById(id).setWishlist(null);
        wishlistRepository.deleteAll();
    }

    public Wishlist getById(Integer id) {
        return userRepository.getById(id).getWishlist();
    }
}
