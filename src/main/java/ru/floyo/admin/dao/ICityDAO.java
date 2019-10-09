package ru.floyo.admin.dao;

import ru.floyo.admin.entity.City;

import java.util.List;

public interface ICityDAO {
    List<City> getAll();
    void add(City cityEntity);
    void delete(City cityEntity);
    void edit(City cityEntity);
    City getById(Integer id);
}
