package com.bosch.logistics.controller.api;

import com.bosch.logistics.entity.Product;
import com.bosch.logistics.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable long id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/find-by-product-status/{productStatusId}")
    public Set<Product> findProductsByProductStatus(@PathVariable long productStatusId) {
        return productService.findAllByProductStatus(productStatusId);
    }

    @GetMapping("/show-received")
    public Set<Product> receivedProducts() {
        return productService.findAllReceivedProducts();
    }

    @GetMapping("/received-count")
    public int receivedProductsCount() {
        return productService.receivedProductsCount();
    }

    @GetMapping("/not-received-products-by-status/{statusId}")
    public Set<Product> notReceivedProductsByStatus(@PathVariable long statusId) {
        return productService.findNotReceivedProductsByStatusId(statusId);
    }

    @GetMapping("/products-received/customer/{receiverId}/{startDate}/{endDate}")
    public Set<Product> findAllByReceiverAndReceivedDateBetween(@PathVariable long receiverId, @PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return productService.findAllByReceiverAndReceivedDateBetween(receiverId, startDate, endDate);
    }

    @GetMapping("/find-between-weight/{min}/{max}")
    public Set<Product> findAllByWeightBetween(@PathVariable String min, @PathVariable String max) {
        return productService.findAllByWeightBetween(min, max);
    }

    @GetMapping("/find-between-received-date/{min}/{max}")
    public Set<Product> findAllByReceivedDateBetween(@PathVariable String min, @PathVariable String max) {
        return productService.findAllByReceivedDateBetween(LocalDate.parse(min), LocalDate.parse(max));
    }

    @GetMapping("/count-between-received-date/{min}/{max}")
    public int countAllByReceivedDateBetween(@PathVariable String min, @PathVariable String max) {
        return productService.countAllByReceivedDateBetween(LocalDate.parse(min), LocalDate.parse(max));
    }

    @GetMapping("/find-by-received-date/{date}")
    public Set<Product> findAllByReceivedDate(@PathVariable String date) {
        return productService.findAllByReceivedDate(LocalDate.parse(date));
    }

    @GetMapping("/count-by-received-date/{date}")
    public int countAllByReceivedDate(@PathVariable String date) {
        return productService.countAllByReceivedDate(LocalDate.parse(date));
    }

    @GetMapping("/products-by-customers-city/{customerCity}")
    public Set<Product> productsByCustomersCity(@PathVariable String customerCity) {
        return productService.productsByCustomersCity(customerCity);
    }

    @GetMapping("/count-products-by-customers-city/{customerCity}")
    public int countProductsByCustomersCity(@PathVariable String customerCity) {
        return productService.countProductsByCustomersCity(customerCity);
    }

    @GetMapping("/find-by-registeredDate/{registeredDate}")
    public Set<Product> findAllByRegisteredDateOrderByNameAsc(@PathVariable String registeredDate) {
        return productService.findAllByRegisteredDateOrderByNameAsc(LocalDate.parse(registeredDate));
    }
}
