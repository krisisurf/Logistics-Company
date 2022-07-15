package com.bosch.logistics.controller.api;

import com.bosch.logistics.entity.Office;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.service.OfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/office")
public class OfficeController {

    private OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public List<Office> getOffices() {
        return this.officeService.getOffices();
    }

    @GetMapping("/{officeId}")
    public Office getOffice(@PathVariable long officeId) {
        return this.officeService.getOffice(officeId);
    }

    @PostMapping
    public Office create(@RequestBody Office office) {
        return officeService.create(office);
    }

    @PutMapping("/{officeId}")
    public Office update(@RequestBody Office office, @PathVariable long officeId) {
        return officeService.update(office, officeId);
    }

    @DeleteMapping("/{officeId}")
    public void delete(@PathVariable long officeId) {
        officeService.delete(officeId);
    }

}
