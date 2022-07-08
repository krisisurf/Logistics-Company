package com.bosch.logistics.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 16)
    private String status;

    @OneToMany(mappedBy = "productStatus")
    private Set<Product> products;
}

enum Statuses{
    OFFICEPROCCESING, TRANSIT, DELIVERED, RECIEVED
}
