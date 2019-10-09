package ru.floyo.admin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.Order;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class OrderDAO implements IOrderDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Order").list();
    }

    @Override
    public void add(Order item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public void delete(Order item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(Order item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public Order getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }


}