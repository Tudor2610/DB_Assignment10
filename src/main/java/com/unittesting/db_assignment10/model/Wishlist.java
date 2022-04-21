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
public class Wishlist {
    @Id
    @NotNull
    @GeneratedValue
    private Integer id;

    @OneToOne
    User user;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Product> productList;
}
