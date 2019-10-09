package ru.floyo.admin.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.Collection;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CollectionDAO implements ICollectionDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Collection> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Collection").list();
    }

    @Override
    public void add(Collection item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public void delete(Collection item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(Collection item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public Collection getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Collection.class, id);
    }


}