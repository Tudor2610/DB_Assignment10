package com.unittesting.db_assignment10.service;

import com.unittesting.db_assignment10.model.User;
import com.unittesting.db_assignment10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        List<User> aux = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public User getUserById(Integer id) {
        return userRepository.getById(id);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> filterByOrderNumber() {
        return getAll().stream().sorted(Comparator.comparing(user -> user.getCart().size())).collect(Collectors.toList());
    }

    public List<User> filterByCartQuantity() {
        return getAll().stream().sorted(Comparator.comparing(user -> user.getNumberOfOrders())).collect(Collectors.toList());
    }
}
