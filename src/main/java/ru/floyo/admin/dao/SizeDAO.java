package ru.floyo.admin.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.Size;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SizeDAO implements ISizeDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Size> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Size").list();
    }

    @Override
    public void add(Size item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public void delete(Size item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(Size item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public Size getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Size.class, id);
    }


}