package ru.floyo.admin.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.City;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CityDAO implements ICityDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<City> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from City").list();
    }

    @Override
    public void add(City item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    public void delete(City item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(City item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public City getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(City.class, id);
    }


}