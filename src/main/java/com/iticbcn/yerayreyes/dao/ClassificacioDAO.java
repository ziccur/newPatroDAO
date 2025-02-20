package com.iticbcn.yerayreyes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iticbcn.yerayreyes.HibernateUtil;
import com.iticbcn.yerayreyes.model.Classificacio;

public class ClassificacioDAO{

    public void create(Classificacio classificacio) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(classificacio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en ClassificacioDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public Classificacio findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Classificacio.class, id);
        } catch (Exception e) {
            System.out.println("Error en ClassificacioDAO: " + e.getMessage());
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    public void update(Classificacio classificacio) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(classificacio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en ClassificacioDAO: " + e.getMessage());
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
            Classificacio classificacio = session.get(Classificacio.class, id);
            if (classificacio != null) {
                session.remove(classificacio);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en ClassificacioDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public static long count() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "SELECT COUNT(c) FROM Classificacio c";
            return (Long) session.createQuery(hql).uniqueResult();
        } catch (Exception e) {
            System.out.println("Error en ClassificacioDAO: " + e.getMessage());
            return 0;
        } finally {
            if (session != null) session.close();
        }
    }

    public static List<Classificacio> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Classificacio";
            return session.createQuery(hql, Classificacio.class).list();
        } catch (Exception e) {
            System.out.println("Error en ClassificacioDAO: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            if (session != null) session.close();
        }
    }

}

