package com.iticbcn.yerayreyes.dao;

import org.hibernate.SessionFactory;

import com.iticbcn.yerayreyes.model.Equip;

public class EquipDAO extends GenDAOImpl<Equip> {

    public EquipDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Equip.class);
    }

}