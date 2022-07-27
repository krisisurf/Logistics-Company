package com.bosch.logistics.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Column(nullable = false)
    private String firstName;


    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false)
    private String tel;

    @OneToMany(mappedBy = "sender")
    @JsonIgnore//Properties("sender")
    private Set<Product> productsSent;

    @OneToMany(mappedBy = "receiver")
    @JsonIgnore//Properties("receiver")
    private Set<Product> productsReceive;

    public Customer(long id) {
        super(id);
    }

    public Customer() {
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAbbreviatedFullName(){
        return firstName.charAt(0) + ". " + lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set<Product> getProductsSent() {
        return productsSent;
    }

    public void setProductsSent(Set<Product> productsSent) {
        this.productsSent = productsSent;
    }

    public Set<Product> getProductsReceive() {
        return productsReceive;
    }

    public void setProductsReceive(Set<Product> productsReceive) {
        this.productsReceive = productsReceive;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + super.getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Set<Product> getAllProducts() {
        Set<Product> allProducts = new HashSet<>(getProductsSent());
        allProducts.addAll(getProductsReceive());
        return allProducts;
    }
}
