package com.bosch.logistics.service;

import com.bosch.logistics.entity.Office;
import com.bosch.logistics.entity.Product;

import java.util.List;
import java.util.Set;

public interface OfficeService {
    List<Office> getOffices();
    Office getOffice(long id);
    Office create(Office office);
    Set<Product> productsInOffice(long officeId);
    int productsInOfficeCount(long officeId);
    Office update(Office office, long id);
    void delete(long id);
}
