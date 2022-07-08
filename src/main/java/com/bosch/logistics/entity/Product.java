package com.bosch.logistics.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false)
    private String weight;

    @Column(nullable = false)
    private LocalDate registeredDate;

    private LocalDate receivedDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ProductStatus productStatus;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ProductType productType;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer sender;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer receiver;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Address senderAddress;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Address receiverAddress;

    @ManyToOne
    @JoinColumn(nullable = false)
    private DeliveryTime deliveryTime;
}
