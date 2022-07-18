package com.bosch.logistics.service.implementation;


import com.bosch.logistics.entity.Office;
import com.bosch.logistics.repository.OfficeRepository;
import com.bosch.logistics.service.OfficeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private OfficeRepository officeRepository;

    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    @Override
    public Office getOffice(long id) {
        return officeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id: " + id));
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


}
