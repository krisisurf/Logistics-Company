package com.bosch.logistics.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnore//Properties("senderAddress")
    private Set<Product> senderProducts;

    @OneToMany(mappedBy = "receiverAddress")
    @JsonIgnore//Properties("receiverAddress")
    private Set<Product> receiverProducts;

    @OneToOne(mappedBy = "address")
    @JsonIgnoreProperties("address")
    private Office office;

    @OneToMany(mappedBy = "address")
    @JsonIgnoreProperties("address")
    private Set<Customer> customers;

    public Address() {
    }

    public Address(long id) {
        this.id = id;
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

    public Set<Product> getSenderProducts() {
        return senderProducts;
    }

    public void setSenderProducts(Set<Product> senderProducts) {
        this.senderProducts = senderProducts;
    }

    public Set<Product> getReceiverProducts() {
        return receiverProducts;
    }

    public void setReceiverProducts(Set<Product> receiverProducts) {
        this.receiverProducts = receiverProducts;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
