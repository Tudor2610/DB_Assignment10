package com.unittesting.db_assignment10.repository;

import com.unittesting.db_assignment10.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User getById(Integer id);
}
