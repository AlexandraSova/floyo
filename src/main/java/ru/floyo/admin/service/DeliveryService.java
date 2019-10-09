package ru.floyo.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.IDeliveryDAO;
import ru.floyo.admin.entity.Delivery;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {

    @Autowired
    private IDeliveryDAO deliveryDAO;

    @Transactional
    @Override
    public List<Delivery> getAll() {

        return deliveryDAO.getAll();
    }
    @Transactional
    @Override
    public void add(Delivery item) {

        deliveryDAO.add(item);
    }
    @Transactional
    @Override
    public void delete(Delivery item)
    {
        deliveryDAO.delete(item);
    }
    @Transactional
    @Override
    public void edit(Delivery item) {

        deliveryDAO.edit(item);
    }
    @Transactional
    @Override
    public Delivery getById(Integer id) {

        return deliveryDAO.getById(id);
    }
}