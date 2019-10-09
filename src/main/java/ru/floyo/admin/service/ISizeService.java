package ru.floyo.admin.service;

import ru.floyo.admin.entity.Size;

import java.util.List;

public interface ISizeService {
    List<Size> getAll();
    void add(Size size);
    void delete(Size size);
    void edit(Size size);
    Size getById(String id);
}
