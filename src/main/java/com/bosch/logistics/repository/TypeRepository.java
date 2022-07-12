package com.bosch.logistics.repository;

import com.bosch.logistics.entity.ProductType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<ProductType, Long> {

}