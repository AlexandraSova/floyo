package ru.floyo.admin.dao;

import ru.floyo.admin.entity.Order;

import java.util.List;

public interface IOrderDAO {
    List<Order> getAll();
    void add(Order order);
    void delete(Order order);
    void edit(Order order);
    Order getById(Integer id);
}
