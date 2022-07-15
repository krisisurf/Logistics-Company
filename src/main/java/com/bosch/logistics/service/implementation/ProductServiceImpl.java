package com.bosch.logistics.service.implementation;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.repository.ProductRepository;
import com.bosch.logistics.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
}
