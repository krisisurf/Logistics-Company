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

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
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

    @GetMapping("/product-status-id/{id}")
    public List<Product> nullableStatusId(@PathVariable long id){
        return productService.findAllByReceivedDateIsNullAndProductStatusId(id);
    }
    @GetMapping("/customer-sender-address/{addressId}")
    public List<Customer> senderAddressTown(@PathVariable String addressId){
        return productService.findAllBySenderId(addressId);
    }
    @GetMapping("/products-received/customer/{id}/{startDate}/{endDate}")
    public List<Product> productsReceived(@PathVariable long id, @PathVariable LocalDate startDate,@PathVariable LocalDate endDate){
        return productService.findAllByReceiverAndReceivedDateBetween(id,startDate,endDate);
    }
//    @GetMapping("/products-received/customer/{id}/{startDate}")
//    public List<Product> productsReceived(@PathVariable long id, LocalDate startDate, LocalDate endDate){
//        return productService.findAllReceivedDate(startDate);
//    }
}
