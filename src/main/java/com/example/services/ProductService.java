package com.example.services;

import com.example.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product saveOrUpdate(Product product);

    Product getById(UUID uuid);

    List<Product> listAll();

    void deleteById(UUID uuid);
}
