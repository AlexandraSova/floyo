package ru.floyo.admin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.IOrderLineDAO;
import ru.floyo.admin.entity.OrderLine;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderLineService implements IOrderLineService {


    @Autowired
    private IOrderLineDAO orderLineDAO;

    @Transactional
    @Override
    public List<OrderLine> getAll() {
        return orderLineDAO.getAll();
    }
    @Transactional
    @Override
    public void add(OrderLine item) {

        orderLineDAO.add(item);
    }
    @Transactional
    @Override
    public void delete(OrderLine item)
    {
        orderLineDAO.delete(item);
    }
    @Transactional
    @Override
    public void edit(OrderLine item) {

        orderLineDAO.edit(item);
    }
    @Transactional
    @Override
    public OrderLine getById(Integer id) {

        return orderLineDAO.getById(id);
    }
}