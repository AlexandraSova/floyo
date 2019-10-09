package ru.floyo.admin.service;

import ru.floyo.admin.entity.Collection;

import java.util.List;

public interface ICollectionService {
    List<Collection> getAll();
    void add(Collection collection);
    void delete(Collection collection);
    void edit(Collection collection);
    Collection getById(Integer id);
}
