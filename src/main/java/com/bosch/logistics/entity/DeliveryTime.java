package com.bosch.logistics.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DeliveryTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false)
    private int deliveryDays;

    @Column(nullable = false)
    private int deliveryHours;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private boolean isAvailable;

    @OneToMany(mappedBy = "deliveryTime")
    private Set<Product> products;
}
