package ru.floyo.admin.service;

import ru.floyo.admin.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
    void add(Category category);
    void delete(Category category);
    void edit(Category category);
    Category getById(String id);
}
