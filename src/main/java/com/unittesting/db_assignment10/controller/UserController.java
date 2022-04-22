package com.unittesting.db_assignment10.controller;

import com.unittesting.db_assignment10.model.User;
import com.unittesting.db_assignment10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/remove/{id}")
    public String removeUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "Deleted";
    }

    @GetMapping("/users/filter/order")
    public List<User> getFilteredByOrder() {
        return userService.filterByOrderNumber();
    }

    @GetMapping("/users/filter/quantity")
    public List<User> getFilteredByQuantity() {
        return userService.filterByCartQuantity();
    }
}
