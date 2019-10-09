package ru.floyo.admin.dao;

import ru.floyo.admin.entity.Collection;

import java.util.List;

public interface ICollectionDAO {
    List<Collection> getAll();
    void add(Collection collection);
    void delete(Collection collection);
    void edit(Collection collection);
    Collection getById(Integer id);
}
