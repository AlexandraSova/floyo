package ru.floyo.admin.dao;

import ru.floyo.admin.entity.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAll();
    void add(Product product);
    void delete(Product product);
    void edit(Product product);
    Product getById(Integer id);
}
