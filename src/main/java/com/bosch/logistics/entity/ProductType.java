package com.bosch.logistics.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 45)
    private String typeName;

    @Column(nullable = false)
    private double price;

    @OneToMany(mappedBy = "productType")
    private Set<Product> products;
}
