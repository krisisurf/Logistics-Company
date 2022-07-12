package com.bosch.logistics.service;

import com.bosch.logistics.entity.ProductStatus;

import java.util.List;

public interface StatusService {
    List<ProductStatus> getStatuses();
    ProductStatus getStatus(long id);
    ProductStatus create(ProductStatus status);
    ProductStatus update(ProductStatus status, long id);
    void delete(long id);
}