package com.bosch.logistics.service.implementation;

import com.bosch.logistics.entity.Product;
import com.bosch.logistics.repository.ProductRepository;
import com.bosch.logistics.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
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
}
