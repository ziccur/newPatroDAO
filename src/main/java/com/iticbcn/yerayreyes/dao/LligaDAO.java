package com.iticbcn.yerayreyes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iticbcn.yerayreyes.HibernateUtil;
import com.iticbcn.yerayreyes.model.Lliga;

public class LligaDAO extends GenDAOImpl<Lliga> {

    public LligaDAO() {
        super(HibernateUtil.getSessionFactory(), Lliga.class);
    }

    public void create(Lliga lliga) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(lliga);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en LligaDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public Lliga findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Lliga.class, id);
        } catch (Exception e) {
            System.out.println("Error en LligaDAO: " + e.getMessage());
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    public void update(Lliga lliga) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(lliga);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en LligaDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Lliga lliga = session.get(Lliga.class, id);
            if (lliga != null) {
                session.remove(lliga);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en LligaDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public static long count() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "SELECT COUNT(l) FROM Lliga l";
            return (Long) session.createQuery(hql).uniqueResult();
        } catch (Exception e) {
            System.out.println("Error en LligaDAO: " + e.getMessage());
            return 0;
        } finally {
            if (session != null) session.close();
        }
    }

    public static List<Lliga> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Lliga";
            return session.createQuery(hql, Lliga.class).list();
        } catch (Exception e) {
            System.out.println("Error en LligaDAO: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            if (session != null) session.close();
        }
    }

}
