package com.bosch.logistics.service;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddresses();

    Address getAddress(long id);

    Address createAddress(Address address);

    Address updateAddress(Address address, long id);

    void deleteAddress(long id);

    List<Address> findAllAddressesByCityOrCode(String city, String code);

    List<Address> findByCity(String city);

    int countByCity(String city);

    List<Address> findByCode(String code);
}
