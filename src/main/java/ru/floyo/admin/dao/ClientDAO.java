package ru.floyo.admin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.Client;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ClientDAO implements IClientDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Client> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client").list();
    }

    @Override
    public void add(Client item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public void delete(Client item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(Client item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public Client getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, id);
    }


}