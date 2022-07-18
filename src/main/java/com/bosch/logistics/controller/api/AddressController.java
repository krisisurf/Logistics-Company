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

//    @GetMapping("/city/{city}/code/{code}")
//    List<Address> findAllAddressesByCityOrCode(@PathVariable String city, @PathVariable String code){
//        return service.findAllAddressesByCityOrCode(city, code);
//    }

    @GetMapping("/city-or-code")
    @ResponseBody
    public List<Address> findAllAddressesByCityOrCode(@RequestParam(required = false) String city, @RequestParam(required = false) String code) {
        return service.findAllAddressesByCityOrCode(city, code);
    }

    @GetMapping("/city/{city}")
    public List<Address> findByCity(@PathVariable("city") String city) {
        return service.findByCity(city);
    }

    @GetMapping("/code/{code}")
    public List<Address> findByCode(@PathVariable("code") String code) {
        return service.findByCode(code);
    }

}
