package com.bosch.logistics.controller.api;

import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return service.getProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable long id) {
        return service.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        service.deleteProduct(id);
    }

    @GetMapping("/findbetweenweight/{min}/{max}")
    public List<Product> findAllByWeightBetween(@PathVariable("min") String min, @PathVariable("max") String max) {
        return service.findAllByWeightBetween(min,max);
    }

    @GetMapping("/findbetweendate/{min}/{max}")
    public List<Product> findAllByReceivedDateBetween(@PathVariable("min") String min, @PathVariable("max") String max) {
        return service.findAllByReceivedDateBetween(LocalDate.parse(min),LocalDate.parse(max));
    }

    @GetMapping("/countbetweendate/{min}/{max}")
    public int countAllByReceivedDateBetween(@PathVariable("min") String min, @PathVariable("max") String max) {
        return service.countAllByReceivedDateBetween(LocalDate.parse(min),LocalDate.parse(max));
    }

    @GetMapping("/countdate/{date}")
    public int countAllByReceivedDate(@PathVariable("date") String date) {
        return service.countAllByReceivedDate(LocalDate.parse(date));
    }

    @GetMapping("/finddate/{date}")
    public List<Product> findAllByReceivedDate(@PathVariable("date") String date) {
        return service.findAllByReceivedDate(LocalDate.parse(date));
    }


}
