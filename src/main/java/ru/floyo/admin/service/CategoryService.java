package ru.floyo.admin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.ICategoryDAO;
import ru.floyo.admin.entity.Category;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDAO categoryDAO;

    @Transactional
    @Override
    public List<Category> getAll() {

        return categoryDAO.getAll();
    }
    @Transactional
    @Override
    public void add(Category item) {

        categoryDAO.add(item);
    }
    @Transactional
    @Override
    public void delete(Category item)
    {
        categoryDAO.delete(item);
    }
    @Transactional
    @Override
    public void edit(Category item) {

        categoryDAO.edit(item);
    }
    @Transactional
    @Override
    public Category getById(String id) {

        return categoryDAO.getById(id);
    }
}