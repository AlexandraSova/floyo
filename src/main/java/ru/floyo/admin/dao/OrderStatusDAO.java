package ru.floyo.admin.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.OrderStatus;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class OrderStatusDAO implements IOrderStatusDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<OrderStatus> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OrderStatus").list();
    }

    @Override
    public void add(OrderStatus item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public void delete(OrderStatus item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(OrderStatus item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public OrderStatus getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(OrderStatus.class, id);
    }


}