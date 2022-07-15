package com.bosch.logistics.service;

import com.bosch.logistics.entity.Office;
import com.bosch.logistics.entity.Product;

import java.util.List;
import java.util.Set;

public interface OfficeService {
    List<Office> getOffices();
    Office getOffice(long officeId);
    Office create(Office office);
    Office update(Office office, long officeId);
    void delete(long officeId);

    Set<Product> productsInOffice(long officeId);
    int productsInOfficeCount(long officeId);
}
