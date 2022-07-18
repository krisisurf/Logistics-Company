package com.bosch.logistics.service.implementation;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.repository.AddressRepository;
import com.bosch.logistics.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repo;

    public AddressServiceImpl(AddressRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public List<Address> getAddresses() {
        return repo.findAll();
    }

    @Override
    public Address getAddress(long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));
    }

    @Override
    public Address createAddress(Address address) {
        return repo.save(address);
    }

    @Override
    public Address updateAddress(Address address, long id) {
        address.setId(id);
        return repo.save(address);
    }

    @Override
    public void deleteAddress(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Address> findAllAddressesByCityOrCode(String city, String code) {
        return repo.findAllAddressesByCityOrCode(city, code);
    }
    
    @Override
    public List<Address> findByCity(String city) {
        return repo.findAllByCity(city);
    }

    @Override
    public List<Address> findByCode(String code) {
        return repo.findAllByCode(code);
    }


}
