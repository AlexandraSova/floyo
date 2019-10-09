package ru.floyo.admin.dao;

import ru.floyo.admin.entity.Size;

import java.util.List;

public interface ISizeDAO {
    List<Size> getAll();
    void add(Size size);
    void delete(Size size);
    void edit(Size size);
    Size getById(String id);
}
