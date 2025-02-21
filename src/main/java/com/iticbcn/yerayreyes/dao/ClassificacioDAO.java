package com.iticbcn.yerayreyes.dao;

import com.iticbcn.yerayreyes.HibernateUtil;
import com.iticbcn.yerayreyes.model.Classificacio;

public class ClassificacioDAO extends GenDAOImpl<Classificacio> {

        public ClassificacioDAO(Class<Classificacio> classe) {
            super(HibernateUtil.getSessionFactory(),classe);
        }

}

