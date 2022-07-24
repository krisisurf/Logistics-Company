package com.bosch.logistics.repository;

import com.bosch.logistics.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllAddressesByCityOrCode(String city, String code);
    List<Address> findAllByCity(String city);
    int countByCity(String city);
    List<Address> findAllByCode(String code);
}
