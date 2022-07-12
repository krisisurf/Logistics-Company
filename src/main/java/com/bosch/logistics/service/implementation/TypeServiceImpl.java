package com.bosch.logistics.service.implementation;

import com.bosch.logistics.entity.ProductType;
import com.bosch.logistics.repository.TypeRepository;

import com.bosch.logistics.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<ProductType> getTypes() {
        return typeRepository.findAll();
    }


    @Override
    public ProductType getType(long id) {
        return typeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id: " + id));
    }

    @Override
    public ProductType create(ProductType type) {
        return typeRepository.save(type);
    }

    @Override
    public ProductType update(ProductType type, long id) {
        type.setId(id);
        return typeRepository.save(type);
    }

    @Override
    public void delete(long id) {
        typeRepository.deleteById(id);
    }
}