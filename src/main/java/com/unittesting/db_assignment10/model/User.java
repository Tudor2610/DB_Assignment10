package com.unittesting.db_assignment10.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @NotNull
    @GeneratedValue
    private Integer id;
    @NotNull
    private String name;

    @OneToOne
    private Wishlist wishlist;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Cart> cart;


    public int getNumberOfOrders(){
        int sum = 0;
        for (Cart c : cart) {
            sum += c.getProductList().size();
        }
        return sum;
    }
}
