package ru.floyo.admin.dao;

import ru.floyo.admin.entity.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> getAll();
    void add(Category category);
    void delete(Category category);
    void edit(Category category);
    Category getById(String id);
}
