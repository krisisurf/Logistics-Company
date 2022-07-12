package com.bosch.logistics.service.implementation;

import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.repository.StatusRepository;
import com.bosch.logistics.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<ProductStatus> getStatuses() {
        return statusRepository.findAll();
    }


    @Override
    public ProductStatus getStatus(long id) {
        return statusRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id: " + id));
    }

    @Override
    public ProductStatus create(ProductStatus status) {
        return statusRepository.save(status);
    }

    @Override
    public ProductStatus update(ProductStatus status, long id) {
        status.setId(id);
        return statusRepository.save(status);
    }

    @Override
    public void delete(long id) {
        statusRepository.deleteById(id);
    }
}