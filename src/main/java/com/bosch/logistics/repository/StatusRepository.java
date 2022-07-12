package com.bosch.logistics.repository;

import com.bosch.logistics.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<ProductStatus, Long> {

}