package com.bosch.logistics.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Product(long id) {
        this.id = id;
    }

    public Product() {

    }

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false)
    private String weight;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registeredDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public Address getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(Address senderAddress) {
        this.senderAddress = senderAddress;
    }

    public Address getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(Address receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public DeliveryTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(DeliveryTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", registeredDate=" + registeredDate +
                ", receivedDate=" + receivedDate +
                '}';
    }
}
