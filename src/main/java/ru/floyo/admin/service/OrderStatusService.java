package ru.floyo.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.IOrderStatusDAO;
import ru.floyo.admin.entity.OrderStatus;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderStatusService implements IOrderStatusService {


    @Autowired
    private IOrderStatusDAO orderStatusDAO;

    @Transactional
    @Override
    public List<OrderStatus> getAll() {
        return orderStatusDAO.getAll();
    }
    @Transactional
    @Override
    public void add(OrderStatus item) {

        orderStatusDAO.add(item);
    }
    @Transactional
    @Override
    public void delete(OrderStatus item)
    {
        orderStatusDAO.delete(item);
    }
    @Transactional
    @Override
    public void edit(OrderStatus item) {

        orderStatusDAO.edit(item);
    }
    @Transactional
    @Override
    public OrderStatus getById(String id) {

        return orderStatusDAO.getById(id);
    }
}