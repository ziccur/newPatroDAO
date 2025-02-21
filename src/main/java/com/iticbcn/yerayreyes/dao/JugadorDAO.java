package com.iticbcn.yerayreyes.dao;

import org.hibernate.SessionFactory;

import com.iticbcn.yerayreyes.model.Jugador;

public class JugadorDAO extends GenDAOImpl<Jugador> {

    public JugadorDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Jugador.class);
    }

}
