package ru.floyo.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.IOrderDAO;
import ru.floyo.admin.entity.Order;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDAO orderDAO;

    @Transactional
    @Override
    public List<Order> getAll() {

        return orderDAO.getAll();
    }
    @Transactional
    @Override
    public void add(Order item) {

        orderDAO.add(item);
    }
    @Transactional
    @Override
    public void delete(Order item)
    {
        orderDAO.delete(item);
    }
    @Transactional
    @Override
    public void edit(Order item) {

        orderDAO.edit(item);
    }
    @Transactional
    @Override
    public Order getById(Integer id) {

        return orderDAO.getById(id);
    }
}