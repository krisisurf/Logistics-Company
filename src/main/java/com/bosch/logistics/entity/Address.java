package com.bosch.logistics.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 45)
    private String city;

    @Column(length = 45)
    private String street;

    @Column(length = 45)
    private String number;

    @Column(length = 10)
    private String code;

    @OneToMany(mappedBy = "senderAddress")
    private Set<Product> senderProducts;

    @OneToMany(mappedBy = "receiverAddress")
    private Set<Product> receiverProducts;

    @OneToOne(mappedBy = "address")
    private Office office;

    @OneToMany(mappedBy = "address")
    private Set<Customer> customers;
}
