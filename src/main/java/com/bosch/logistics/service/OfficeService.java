package com.bosch.logistics.service;

import com.bosch.logistics.entity.Office;

import java.util.List;

public interface OfficeService {
    List<Office> getOffices();
    Office getOffice(long id);
    Office create(Office office);
    Office update(Office office, long id);
    void delete(long id);
}
