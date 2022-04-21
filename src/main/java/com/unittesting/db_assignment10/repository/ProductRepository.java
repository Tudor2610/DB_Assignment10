package com.unittesting.db_assignment10.repository;

import com.unittesting.db_assignment10.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Product getById(Integer id);
}
