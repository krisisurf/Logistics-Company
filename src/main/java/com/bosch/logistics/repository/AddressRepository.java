package com.bosch.logistics.repository;

import com.bosch.logistics.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
