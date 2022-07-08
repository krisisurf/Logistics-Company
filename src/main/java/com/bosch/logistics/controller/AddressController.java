package com.bosch.logistics.controller;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController{
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAddresses(){
        return this.addressService.getAddresses();
    }
}
