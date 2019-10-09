package ru.floyo.admin.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.OrderLine;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class OrderLineDAO implements IOrderLineDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<OrderLine> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OrderLine").list();
    }

    @Override
    public void add(OrderLine item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public void delete(OrderLine item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(OrderLine item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public OrderLine getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(OrderLine.class, id);
    }


}