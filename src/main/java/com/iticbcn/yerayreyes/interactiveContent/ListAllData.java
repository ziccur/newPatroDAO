package com.iticbcn.yerayreyes.interactiveContent;

import java.util.ArrayList;

import org.hibernate.SessionFactory;

import com.iticbcn.yerayreyes.HibernateUtil;
import com.iticbcn.yerayreyes.dao.ClassificacioDAO;
import com.iticbcn.yerayreyes.dao.EquipDAO;
import com.iticbcn.yerayreyes.dao.JugadorDAO;
import com.iticbcn.yerayreyes.dao.LligaDAO;
import com.iticbcn.yerayreyes.model.Classificacio;
import com.iticbcn.yerayreyes.model.Equip;
import com.iticbcn.yerayreyes.model.Jugador;
import com.iticbcn.yerayreyes.model.Lliga;

public class ListAllData {
    
    static SessionFactory session = HibernateUtil.getSessionFactory();

    static ClassificacioDAO classificacioDAO = new ClassificacioDAO(session);
    static EquipDAO equipDAO = new EquipDAO(session);
    static JugadorDAO jugadorDAO = new JugadorDAO(session);
    static LligaDAO lligaDAO = new LligaDAO(session);

    @SuppressWarnings("empty-statement")
    public static void listAllData(int opcio){
        System.out.println("############################");
        switch (opcio) {
            case 1 -> listLliga();
            case 2 -> listEquip();
            case 3 -> listJugador();
            case 4 -> listClassificacio();
        };
    }

    public static void listJugador(){
        try{
            ArrayList<Jugador> jugadors = new ArrayList<>(jugadorDAO.getAll());
            if (jugadors.isEmpty()) {
                System.out.println("No hi ha jugadors per mostrar");
                System.exit(1);
            }

            System.out.println("Llista de Jugadors:");
            for (Jugador jugador : jugadors) {
                System.out.println(jugador.toString());
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
        }

    }

    public static void listEquip(){

        try{
            ArrayList<Equip> equips = new ArrayList<>(equipDAO.getAll());
            if (equips.isEmpty()) {
                System.out.println("No hi ha equips per mostrar");
                System.exit(1);
            }

            System.out.println("Llista d'Equips:");
            for (Equip equip : equips) {
                System.out.println(equip.toString());
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }

    public static void listClassificacio(){
        try{
            ArrayList<Classificacio> classificacions = new ArrayList<>(classificacioDAO.getAll());
            if (classificacions.isEmpty()) {
                System.out.println("No hi ha classificacions per mostrar");
                System.exit(1);
            }

            System.out.println("Llista de Classificacions:");
            for (Classificacio classificacio : classificacions) {
                System.out.println(classificacio.toString());
            }
        } catch(Exception e){
            System.out.println("Error: "+e);
        }

    }

    public static void listLliga(){

        try{

            ArrayList<Lliga> lligues = new ArrayList<>(lligaDAO.getAll());
            if (lligues.isEmpty()) {
                System.out.println("No hi ha lligues per mostrar");
                System.exit(1);
            }

            System.out.println("Llista de Lligues:");
            for (Lliga lliga : lligues) {
                System.out.println(lliga.toString());
            }
        } catch(Exception e){
            System.out.println("Error: "+e);
        }

    }

}
