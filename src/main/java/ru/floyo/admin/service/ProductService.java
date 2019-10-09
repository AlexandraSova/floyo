package ru.floyo.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.IProductDAO;
import ru.floyo.admin.entity.Product;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService implements IProductService {


    @Autowired
    private IProductDAO clientDAO;

    @Transactional
    @Override
    public List<Product> getAll() {
        return clientDAO.getAll();
    }
    @Transactional
    @Override
    public void add(Product item) {

        clientDAO.add(item);
    }
    @Transactional
    @Override
    public void delete(Product item)
    {
        clientDAO.delete(item);
    }
    @Transactional
    @Override
    public void edit(Product item) {

        clientDAO.edit(item);
    }
    @Transactional
    @Override
    public Product getById(Integer id) {

        return clientDAO.getById(id);
    }
}