package com.bosch.logistics.entity;

import javax.persistence.*;

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Address address;

    public Office(long id) {
        this.id = id;
    }

    public Office() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
