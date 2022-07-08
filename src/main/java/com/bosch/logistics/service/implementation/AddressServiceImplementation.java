package com.bosch.logistics.service.implementation;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.repository.AddressRepository;
import com.bosch.logistics.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService {
    private AddressRepository repository;

    public AddressServiceImplementation(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> getAddresses() {
        return this.repository.findAll();
    }
}
