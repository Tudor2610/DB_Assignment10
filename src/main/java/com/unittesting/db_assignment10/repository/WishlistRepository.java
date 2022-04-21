package com.unittesting.db_assignment10.repository;

import com.unittesting.db_assignment10.model.Wishlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, Integer> {
    public Wishlist getById(Integer id);
}

