package com.bosch.logistics.service;

import com.bosch.logistics.entity.ProductType;


import java.util.List;

public interface TypeService {
    List<ProductType> getTypes();
    ProductType getType(long id);
    ProductType create(ProductType type);
    ProductType update(ProductType type, long id);
    void delete(long id);
}