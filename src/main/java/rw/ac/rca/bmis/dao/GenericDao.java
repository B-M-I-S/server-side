package rw.ac.rca.bmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import rw.ac.rca.bmis.orm.Address;
import rw.ac.rca.bmis.orm.User;
import rw.ac.rca.bmis.util.BmisSessionFactory;

public class GenericDao<T> {

    private SessionFactory sessionFactory;

    public void GenericDAO() {
    }

    public void create(T t){
        Session session = BmisSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
    }

    public T get(int id) {
        Session session = sessionFactory.openSession();
        T t = (T) session.get(GenericDao.class , id);
        session.close();
        return t;
    }

    public List<T> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from ");
        List<T> list = query.list();
        session.close();
        return list;
    }
    public void update(T t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T t = (T) session.get(GenericDao.class,id);
        session.delete(t);
        transaction.commit();
        session.close();
    }
}
