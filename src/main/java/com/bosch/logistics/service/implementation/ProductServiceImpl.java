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
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repo;
    private CustomerService service;

    public ProductServiceImpl(ProductRepository repo, CustomerService service) {
        this.repo = repo;
        this.service = service;
    }

    @Override
    public List<Product> getProducts() {
        return repo.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public Product updateProduct( Product product, long id) {
        product.setId(id);
        return repo.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        repo.deleteById(id);
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
    public int receivedProductsCount() {
        return repo.countByReceivedDateNotNull();
    }

    @Override
    public int countProductsOnAddress(Address address) {
        return repo.countByReceiverAddress(address);
    }

    @Override
    public List<Product> findAllByReceivedDateIsNullAndProductStatusId(long id) {
        return repo.findAllByReceivedDateIsNullAndProductStatusId(id);
    }

    @Override
    public List<Customer> findAllBySenderId(String city) {
        return repo.findAllBySenderId(city);
    }

    @Override
    public List<Product> findAllByReceiverAndReceivedDateBetween(long id, LocalDate startDate, LocalDate endDate) {
        return repo.findAllByReceiverAndReceivedDateBetween(service.getCustomer(id),startDate,endDate);
    }

    @Override
    public List<Product> findAllByReceivedDate(LocalDate date) {
        return repo.findAllByReceivedDate(date);
    }


}
