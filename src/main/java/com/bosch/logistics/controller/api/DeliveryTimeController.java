package com.bosch.logistics.controller.api;

import com.bosch.logistics.entity.DeliveryTime;
import com.bosch.logistics.service.DeliveryTimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveryTime")
public class DeliveryTimeController {

    private DeliveryTimeService deliveryTimeService;

    public DeliveryTimeController(DeliveryTimeService deliveryTimeService) {
        this.deliveryTimeService = deliveryTimeService;
    }

    @GetMapping
    public List<DeliveryTime> getDeliveryTime() {
        return this.deliveryTimeService.getDeliveryTime();
    }

    @GetMapping("/{id}")
    public DeliveryTime getDeliveryTime(@PathVariable("id") long id){
        return this.deliveryTimeService.getdeliveryTime(id);
    }

    @PostMapping("/{id}")
    public DeliveryTime createDeliveryTime(@RequestBody DeliveryTime deliveryTime) {
        return deliveryTimeService.create(deliveryTime);
    }

    @PutMapping("/{id}")
    public DeliveryTime updateDeliveryTime(@RequestBody DeliveryTime deliveryTime, @PathVariable long id) {
        return deliveryTimeService.update(deliveryTime, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDeliveryTime(@PathVariable long id){
        deliveryTimeService.delete(id);
    }
}
