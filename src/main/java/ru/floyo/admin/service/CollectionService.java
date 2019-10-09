package ru.floyo.admin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.ICollectionDAO;
import ru.floyo.admin.entity.Collection;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class CollectionService implements ICollectionService {


    @Autowired
    private ICollectionDAO collectionDAO;

    @Transactional
    @Override
    public List<Collection> getAll() {
        return collectionDAO.getAll();
    }
    @Transactional
    @Override
    public void add(Collection item) {

        collectionDAO.add(item);
    }
    @Transactional
    @Override
    public void delete(Collection item)
    {
        collectionDAO.delete(item);
    }
    @Transactional
    @Override
    public void edit(Collection item) {

        collectionDAO.edit(item);
    }
    @Transactional
    @Override
    public Collection getById(Integer id) {

        return collectionDAO.getById(id);
    }
}