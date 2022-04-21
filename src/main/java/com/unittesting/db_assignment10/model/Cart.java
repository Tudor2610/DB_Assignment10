package com.unittesting.db_assignment10.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @NotNull
    @GeneratedValue
    private Integer id;
    private Date date;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    User user;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> productList;
}
