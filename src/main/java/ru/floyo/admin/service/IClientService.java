package ru.floyo.admin.service;

import ru.floyo.admin.entity.Client;

import java.util.List;

public interface IClientService {
    List<Client> getAll();
    void add(Client client);
    void delete(Client client);
    void edit(Client client);
    Client getById(Integer id);
}
