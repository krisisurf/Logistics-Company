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
}
