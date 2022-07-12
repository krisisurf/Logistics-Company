package com.bosch.logistics.service;

import com.bosch.logistics.entity.DeliveryTime;

import java.util.List;

public interface DeliveryTimeService {
    List<DeliveryTime> getDeliveryTime();
    DeliveryTime getdeliveryTime(long id);
    DeliveryTime create(DeliveryTime DeliveryTime);
    DeliveryTime update(DeliveryTime DeliveryTime, long id);
    void delete(long id);
}
