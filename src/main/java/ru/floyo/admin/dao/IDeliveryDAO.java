package ru.floyo.admin.dao;

import ru.floyo.admin.entity.Delivery;

import java.util.List;

public interface IDeliveryDAO {
    List<Delivery> getAll();
    void add(Delivery delivery);
    void delete(Delivery delivery);
    void edit(Delivery delivery);
    Delivery getById(Integer id);
}
