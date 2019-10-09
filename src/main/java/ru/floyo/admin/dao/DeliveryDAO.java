package ru.floyo.admin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.Delivery;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class DeliveryDAO implements IDeliveryDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Delivery> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Delivery").list();
    }

    @Override
    public void add(Delivery item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public void delete(Delivery item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(Delivery item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public Delivery getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Delivery.class, id);
    }
}