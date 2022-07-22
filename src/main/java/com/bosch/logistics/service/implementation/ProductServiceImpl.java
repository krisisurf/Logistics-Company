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

    private ProductRepository repo;
    private CustomerService customerService;

    public ProductServiceImpl(ProductRepository repo, CustomerService customerService) {
        this.repo = repo;
        this.customerService = customerService;
    }

    @Override
    public List<Product> getProducts() {
        return repo.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public Product updateProduct(Product product, long id) {
        product.setId(id);
        return repo.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Product> findAllByWeightBetween(String min, String max) {
        return repo.findAllByWeightBetween(min, max);
    }

    @Override
    public Set<Product> findAllByProductStatus(long productStatusId) {
        ProductStatus productStatus = new ProductStatus(productStatusId);
        return repo.findAllByProductStatus(productStatus);
    }


    @Override
    public Set<Product> findAllReceivedProducts() {
        return repo.findAllByReceivedDateNotNull();
    }

    @Override
    public List<Product> findAllByReceivedDateBetween(LocalDate min, LocalDate max) {
        return repo.findAllByReceivedDateBetween(min, max);
    }

    @Override
    public int receivedProductsCount() {
        return repo.countByReceivedDateNotNull();
    }

    @Override
    public int countAllByReceivedDateBetween(LocalDate min, LocalDate max) {
        return repo.countAllByReceivedDateBetween(min, max);
    }

    @Override
    public int countAllByReceivedDate(LocalDate date) {
        return repo.countAllByReceivedDate(date);
    }

    @Override
    public int countProductsOnAddress(Address address) {
        return repo.countByReceiverAddress(address);
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
    public List<Product> findAllByRegisteredDate(LocalDate date) {
        List<Product> products = repo.findAllByRegisteredDate(date);
        //products.sort(product -> customerService.getCustomer(getProduct().getSender()));
        return products;
    }


    @Override
    public List<Product> findAllByReceivedDate(LocalDate date) {
        return repo.findAllByReceivedDate(date);
    }
}
