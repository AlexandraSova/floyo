package ru.floyo.admin.service;

import ru.floyo.admin.entity.OrderLine;

import java.util.List;

public interface IOrderLineService {
    List<OrderLine> getAll();
    void add(OrderLine orderLine);
    void delete(OrderLine orderLine);
    void edit(OrderLine orderLine);
    OrderLine getById(Integer id);
}
