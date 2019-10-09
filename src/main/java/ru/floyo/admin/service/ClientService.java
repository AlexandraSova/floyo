package ru.floyo.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.floyo.admin.dao.IClientDAO;
import ru.floyo.admin.entity.Client;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService implements IClientService {


    @Autowired
    private IClientDAO clientDAO;

    @Transactional
    @Override
    public List<Client> getAll() {

        return clientDAO.getAll();
    }
    @Transactional
    @Override
    public void add(Client item) {

        clientDAO.add(item);
    }
    @Transactional
    @Override
    public void delete(Client item)
    {
        clientDAO.delete(item);
    }
    @Transactional
    @Override
    public void edit(Client item) {

        clientDAO.edit(item);
    }
    @Transactional
    @Override
    public Client getById(Integer id) {

        return clientDAO.getById(id);
    }
}