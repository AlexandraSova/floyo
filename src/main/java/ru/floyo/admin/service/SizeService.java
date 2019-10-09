package ru.floyo.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.ISizeDAO;
import ru.floyo.admin.entity.Size;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class SizeService implements ISizeService {


    @Autowired
    private ISizeDAO sizeDAO;

    @Transactional
    @Override
    public List<Size> getAll() {
        return sizeDAO.getAll();
    }
    @Transactional
    @Override
    public void add(Size item) {

        sizeDAO.add(item);
    }
    @Transactional
    @Override
    public void delete(Size item)
    {
        sizeDAO.delete(item);
    }
    @Transactional
    @Override
    public void edit(Size item) {

        sizeDAO.edit(item);
    }
    @Transactional
    @Override
    public Size getById(String id) {

        return sizeDAO.getById(id);
    }
}