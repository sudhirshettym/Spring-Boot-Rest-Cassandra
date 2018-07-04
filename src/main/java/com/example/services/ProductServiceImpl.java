package com.example.services;

import com.example.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductService productService;

    public ProductServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productService.saveOrUpdate(product);
    }

    @Override
    public Product getById(UUID uuid) {
        return productService.getById(uuid);
    }

    @Override
    public List<Product> listAll() {
        return productService.listAll();
    }

    @Override
    public void deleteById(UUID uuid) {
        productService.deleteById(uuid);
    }
}
