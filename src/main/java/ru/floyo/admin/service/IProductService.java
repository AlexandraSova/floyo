package ru.floyo.admin.service;

import ru.floyo.admin.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void add(Product product);
    void delete(Product product);
    void edit(Product product);
    Product getById(Integer id);
}
