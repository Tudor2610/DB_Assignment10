package com.unittesting.db_assignment10.service;

import com.unittesting.db_assignment10.model.Product;
import com.unittesting.db_assignment10.model.User;
import com.unittesting.db_assignment10.repository.CartRepository;
import com.unittesting.db_assignment10.repository.ProductRepository;
import com.unittesting.db_assignment10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    public Product addProduct(Product product, Integer id) {
        cartRepository.getById(id).getProductList().add(product);
        return productRepository.save(product);
    }

    public List<Product> getAll(){
        List<Product> aux = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Product getById(Integer id) {
        return productRepository.getById(id);
    }

    public void deleteFromCart(Integer cartId, Integer productId) {
        cartRepository.getById(cartId).getProductList().remove(productRepository.getById(productId));
        productRepository.deleteById(productId);
    }

    public void deleteFromWishlist(Integer wishlistId, Integer productId) {
        userRepository.getById(wishlistId).getWishlist().getProductList().remove(productRepository.getById(productId));
        productRepository.deleteById(productId);
    }

}


