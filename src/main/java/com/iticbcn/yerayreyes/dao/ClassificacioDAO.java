package com.iticbcn.yerayreyes.dao;

import org.hibernate.SessionFactory;

import com.iticbcn.yerayreyes.model.Classificacio;

public class ClassificacioDAO extends GenDAOImpl<Classificacio> {

    public ClassificacioDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Classificacio.class);
    }

}

