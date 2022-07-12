package com.bosch.logistics.repository;

import com.bosch.logistics.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long>{

}
