package ru.floyo.admin.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.floyo.admin.entity.Product;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductDAO implements IProductDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product").list();
    }

    @Override
    public void add(Product item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Override
    public void delete(Product item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public void edit(Product item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public Product getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }


}