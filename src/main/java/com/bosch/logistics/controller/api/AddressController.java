package com.bosch.logistics.controller.api;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public List<Address> getAddresses() {
        return service.getAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable("id") long id) {
        return this.service.getAddress(id);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return service.createAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@RequestBody Address address, @PathVariable long id) {
        return service.updateAddress(address, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable long id) {
        service.deleteAddress(id);
    }

}
