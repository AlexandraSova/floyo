package ru.floyo.admin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.ICityDAO;
import ru.floyo.admin.entity.City;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService implements ICityService {


    @Autowired
    private ICityDAO cityDAO;

    @Transactional
    @Override
    public List<City> getAll() {

        return cityDAO.getAll();
    }

    @Transactional
    @Override
    public void add(City item) {
        cityDAO.add(item);
    }

    @Transactional
    @Override
    public void delete(City item)
    {

        cityDAO.delete(item);
    }

    @Transactional
    @Override
    public void edit(City item) {

        cityDAO.edit(item);
    }
    @Transactional
    @Override
    public City getById(Integer id) {

        return cityDAO.getById(id);
    }
}