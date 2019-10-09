package ru.floyo.admin.service;

import ru.floyo.admin.entity.Delivery;

import java.util.List;

public interface IDeliveryService {
    List<Delivery> getAll();
    void add(Delivery delivery);
    void delete(Delivery delivery);
    void edit(Delivery delivery);
    Delivery getById(Integer id);
}
