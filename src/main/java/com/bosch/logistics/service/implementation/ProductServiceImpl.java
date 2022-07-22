package com.bosch.logistics.service.implementation;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.repository.ProductRepository;
import com.bosch.logistics.service.CustomerService;
import com.bosch.logistics.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CustomerService customerService;

    public ProductServiceImpl(ProductRepository productRepository, CustomerService customerService) {
        this.productRepository = productRepository;
        this.customerService = customerService;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, long id) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Set<Product> findAllByWeightBetween(String min, String max) {
        return productRepository.findAllByWeightBetween(min, max);
    }

    @Override
    public Set<Product> findAllByProductStatus(long productStatusId) {
        ProductStatus productStatus = new ProductStatus(productStatusId);
        return productRepository.findAllByProductStatus(productStatus);
    }


    @Override
    public Set<Product> findAllReceivedProducts() {
        return productRepository.findAllByReceivedDateNotNull();
    }

    @Override
    public Set<Product> findAllByReceivedDateBetween(LocalDate min, LocalDate max) {
        return productRepository.findAllByReceivedDateBetween(min, max);
    }

    @Override
    public int receivedProductsCount() {
        return productRepository.countByReceivedDateNotNull();
    }

    @Override
    public int countAllByReceivedDateBetween(LocalDate min, LocalDate max) {
        return productRepository.countAllByReceivedDateBetween(min, max);
    }

    @Override
    public int countAllByReceivedDate(LocalDate date) {
        return productRepository.countAllByReceivedDate(date);
    }

    @Override
    public int countProductsOnAddress(Address address) {
        return productRepository.countByReceiverAddress(address);
    }

    @Override
    public Set<Product> productsByCustomersCity(String city) {
        Set<Customer> customersFromCity = customerService.findByCity(city);
        Set<Product> products = new HashSet<>();
        customersFromCity.forEach(customer -> products.addAll(customer.getProductsSent()));

        return products;
    }

    @Override
    public int countProductsByCustomersCity(String city) {
        // TODO 100: Needs rework, because this method is slow
        return productsByCustomersCity(city).size();
    }

    @Override
    public Set<Product> findAllByReceivedDate(LocalDate date) {
        return productRepository.findAllByReceivedDate(date);
    }

    @Override
    public Set<Product> findAllByRegisteredDateOrderByNameAsc(LocalDate registeredDate) {
        return productRepository.findAllByRegisteredDateOrderByNameAsc(registeredDate);
    }
}
