package com.bosch.logistics.controller.api;

import com.bosch.logistics.entity.ProductType;
import com.bosch.logistics.service.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productType")
public class TypeController {

    private TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<ProductType> getTypes() {
        return this.typeService.getTypes();
    }

    @GetMapping("/{id}")
    public ProductType getType(@PathVariable("id") long id) {
        return this.typeService.getType(id);
    }

    @PostMapping
    public ProductType createType(@RequestBody ProductType book) {
        return typeService.create(book);
    }

    @PutMapping("/{id}")
    public ProductType updateType(@RequestBody ProductType type, @PathVariable long id) {
        return typeService.update(type, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        typeService.delete(id);
    }



}