package com.bosch.logistics.service.implementation;


import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Office;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.repository.OfficeRepository;
import com.bosch.logistics.service.OfficeService;
import com.bosch.logistics.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    private OfficeRepository officeRepository;
    private ProductService productService;

    public OfficeServiceImpl(OfficeRepository officeRepository, ProductService productService) {
        this.officeRepository = officeRepository;
        this.productService = productService;
    }

    @Override
    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    @Override
    public Office getOffice(long id) {
        return officeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    @Override
    public Office create(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Office update(Office office, long id) {
        office.setId(id);
        return officeRepository.save(office);
    }

    @Override
    public void delete(long id) {
        officeRepository.deleteById(id);
    }

    @Override
    public Set<Product> productsInOffice(long officeId) {
        Office office = getOffice(officeId);
        Address address = office.getAddress();
        return address.getReceiverProducts();
    }

    @Override
    public int productsInOfficeCount(long officeId) {
        Office office = getOffice(officeId);
        Address address = office.getAddress();

        return productService.countProductsOnAddress(address);
    }

    @Override
    public Set<Product> productsInOfficeNotReceived(long officeId) {
        return productsInOffice(officeId).stream().filter(p -> p.getReceivedDate() == null).collect(Collectors.toSet());
    }
}
