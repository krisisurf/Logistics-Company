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

    @GetMapping("/list")
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

    @GetMapping("/findbetweenweight/{min}/{max}")
    public List<Product> findAllByWeightBetween(@PathVariable("min") String min, @PathVariable("max") String max) {
        return productService.findAllByWeightBetween(min, max);
    }

    @GetMapping("/findbetweendate/{min}/{max}")
    public List<Product> findAllByReceivedDateBetween(@PathVariable("min") String min, @PathVariable("max") String max) {
        return productService.findAllByReceivedDateBetween(LocalDate.parse(min), LocalDate.parse(max));
    }

    @GetMapping("/countbetweendate/{min}/{max}")
    public int countAllByReceivedDateBetween(@PathVariable("min") String min, @PathVariable("max") String max) {
        return productService.countAllByReceivedDateBetween(LocalDate.parse(min), LocalDate.parse(max));
    }

    @GetMapping("/countdate/{date}")
    public int countAllByReceivedDate(@PathVariable("date") String date) {
        return productService.countAllByReceivedDate(LocalDate.parse(date));
    }

    @GetMapping("/finddate/{date}")
    public List<Product> findAllByReceivedDate(@PathVariable("date") String date) {
        return productService.findAllByReceivedDate(LocalDate.parse(date));
    }

    @GetMapping("/products-by-customers-city/{customerCity}")
    public Set<Product> productsByCustomersCity(@PathVariable String customerCity){
        return productService.productsByCustomersCity(customerCity);
    }

    @GetMapping("/count-products-by-customers-city/{customerCity}")
    public int countProductsByCustomersCity(@PathVariable String customerCity){
        return productService.countProductsByCustomersCity(customerCity);
    }

}
