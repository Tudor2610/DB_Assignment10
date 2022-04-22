package com.unittesting.db_assignment10.service;

import com.unittesting.db_assignment10.model.Cart;
import com.unittesting.db_assignment10.model.User;
import com.unittesting.db_assignment10.repository.CartRepository;
import com.unittesting.db_assignment10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    public Cart createCart(Cart cart, Integer id) {
        userRepository.getById(id).getCart().add(cart);
        return cartRepository.save(cart);
    }

    public void deleteCart(Integer userId, Integer cartId) {
        userRepository.getById(userId).getCart().remove(cartRepository.getById(cartId));
        cartRepository.deleteById(cartId);
    }

    public List<Cart> getAll() {
        List<Cart> aux = new ArrayList<>();
        cartRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Cart getById(Integer id) {
        return cartRepository.getById(id);
    }

    public List<Cart> filterByQuantity() {
        List<Cart> aux = new ArrayList<>();
        for(Cart x : getAll()) {
            aux.add(x);
        }
        return aux.stream().sorted(Comparator.comparing(cart -> cart.getProductList().size())).collect(Collectors.toList());
    }
}
