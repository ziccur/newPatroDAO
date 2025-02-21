package com.iticbcn.yerayreyes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iticbcn.yerayreyes.HibernateUtil;
import com.iticbcn.yerayreyes.model.Equip;

public class EquipDAO extends GenDAOImpl<Equip> {

    public EquipDAO() {
        super(HibernateUtil.getSessionFactory(), Equip.class);
    }

    public static void create(Equip equip) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(equip);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en EquipDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public static Equip findById(Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Equip.class, id);
        } catch (Exception e) {
            System.out.println("Error en EquipDAO: " + e.getMessage());
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    public void update(Equip equip) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(equip);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en EquipDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public static void delete(Integer id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Equip equip = session.get(Equip.class, id);
            if (equip != null) {
                session.remove(equip);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en EquipDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public static long count() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "SELECT COUNT(e) FROM Equip e";
            return (Long) session.createQuery(hql).uniqueResult();
        } catch (Exception e) {
            System.out.println("Error en EquipDAO: " + e.getMessage());
            return 0;
        } finally {
            if (session != null) session.close();
        }
    }

    public static List<Equip> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Equip";
            return session.createQuery(hql, Equip.class).list();
        } catch (Exception e) {
            System.out.println("Error en EquipDAO: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            if (session != null) session.close();
        }
    }

}