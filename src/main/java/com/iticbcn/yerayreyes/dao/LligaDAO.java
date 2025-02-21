package com.iticbcn.yerayreyes.dao;

import org.hibernate.SessionFactory;

import com.iticbcn.yerayreyes.model.Lliga;

public class LligaDAO extends GenDAOImpl<Lliga> {

        public LligaDAO(SessionFactory sessionFactory) {
            super(sessionFactory,Lliga.class);
    }

}
