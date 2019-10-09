package ru.floyo.admin.service;

import ru.floyo.admin.entity.OrderStatus;

import java.util.List;

public interface IOrderStatusService {
    List<OrderStatus> getAll();
    void add(OrderStatus size);
    void delete(OrderStatus size);
    void edit(OrderStatus size);
    OrderStatus getById(String id);
}
