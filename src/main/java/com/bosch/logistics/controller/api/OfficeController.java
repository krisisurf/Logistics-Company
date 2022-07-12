package com.bosch.logistics.controller.api;

import com.bosch.logistics.entity.Office;
import com.bosch.logistics.service.OfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public Office getOffice(@PathVariable("id") long id) {
        return this.officeService.getOffice(id);
    }

    @PostMapping
    public Office create(@RequestBody Office office) {
        return officeService.create(office);
    }

    @PutMapping("/{id}")
    public Office update(@RequestBody Office office, @PathVariable long id) {
        return officeService.update(office, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        officeService.delete(id);
    }


}
