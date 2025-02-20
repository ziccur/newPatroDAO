package com.iticbcn.yerayreyes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iticbcn.yerayreyes.HibernateUtil;
import com.iticbcn.yerayreyes.model.Jugador;

public class JugadorDAO {

    public void create(Jugador jugador) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(jugador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en JugadorDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public Jugador findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Jugador.class, id);
        } catch (Exception e) {
            System.out.println("Error en JugadorDAO: " + e.getMessage());
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    public void update(Jugador jugador) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(jugador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en JugadorDAO: " + e.getMessage());
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
            Jugador jugador = session.get(Jugador.class, id);
            if (jugador != null) {
                session.remove(jugador);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error en JugadorDAO: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public static long count() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "SELECT COUNT(j) FROM Jugador j";
            return (Long) session.createQuery(hql).uniqueResult();
        } catch (Exception e) {
            System.out.println("Error en JugadorDAO: " + e.getMessage());
            return 0;
        } finally {
            if (session != null) session.close();
        }
    }

    public static List<Jugador> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Jugador";
            return session.createQuery(hql, Jugador.class).list();
        } catch (Exception e) {
            System.out.println("Error en JugadorDAO: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            if (session != null) session.close();
        }
    }

}
