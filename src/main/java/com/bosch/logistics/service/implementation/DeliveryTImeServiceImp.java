package com.bosch.logistics.service.implementation;

import com.bosch.logistics.entity.DeliveryTime;
import com.bosch.logistics.repository.DeliveryTimeRepository;
import com.bosch.logistics.service.DeliveryTimeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryTImeServiceImp implements DeliveryTimeService {

    private DeliveryTimeRepository deliveryTimeRepository;


    public DeliveryTImeServiceImp(DeliveryTimeRepository deliveryTimeRepository) {
        this.deliveryTimeRepository = deliveryTimeRepository;
    }

    @Override
    public List<DeliveryTime> getDeliveryTime() {
        return deliveryTimeRepository.findAll();
    }

    @Override
    public DeliveryTime getdeliveryTime(long id) {
        return deliveryTimeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id: " + id));
    }

    @Override
    public DeliveryTime create(DeliveryTime DeliveryTime) {
        return deliveryTimeRepository.save(DeliveryTime);
    }

    @Override
    public DeliveryTime update(DeliveryTime DeliveryTime, long id) {
        DeliveryTime.setId(id);
        return deliveryTimeRepository.save(DeliveryTime);
    }

    @Override
    public void delete(long id) {
        deliveryTimeRepository.deleteById(id);
    }
}

