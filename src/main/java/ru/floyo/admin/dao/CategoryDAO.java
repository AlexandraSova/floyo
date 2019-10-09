package ru.floyo.admin.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.Category;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CategoryDAO implements ICategoryDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category").list();
    }

    @Override
    public void add(Category item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public void delete(Category item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(Category item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public Category getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }


}