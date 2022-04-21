package com.unittesting.db_assignment10.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @NotNull
    @GeneratedValue
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    private Double quantity;

    @ManyToOne(cascade = {CascadeType.ALL})
    Wishlist wishlist;

    @ManyToOne(cascade = {CascadeType.ALL})
    Cart cart;
}
