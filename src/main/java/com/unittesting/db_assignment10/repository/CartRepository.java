package com.unittesting.db_assignment10.repository;

import com.unittesting.db_assignment10.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
    public Cart getById(Integer id);
}
