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

    public Address(long id, String city, String street, String number, String code) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.number = number;
        this.code = code;
    }

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
