package com.bosch.logistics.controller.api;

import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<ProductStatus> getStatus() {
        return this.statusService.getStatuses();
    }

    @GetMapping("/{id}")
    public ProductStatus getBook(@PathVariable("id") long id) {
        return this.statusService.getStatus(id);
    }

    @PostMapping
    public ProductStatus createBook(@RequestBody ProductStatus status) {
        return statusService.create(status);
    }

    @PutMapping("/{id}")
    public ProductStatus updateStatus(@RequestBody ProductStatus status, @PathVariable long id) {
        return statusService.update(status, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable long id) {
        statusService.delete(id);
    }



}