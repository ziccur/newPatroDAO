package com.iticbcn.yerayreyes.interactiveContent;

import java.util.ArrayList;

import com.iticbcn.yerayreyes.dao.ClassificacioDAO;
import com.iticbcn.yerayreyes.dao.EquipDAO;
import com.iticbcn.yerayreyes.dao.JugadorDAO;
import com.iticbcn.yerayreyes.dao.LligaDAO;
import com.iticbcn.yerayreyes.model.Classificacio;
import com.iticbcn.yerayreyes.model.Equip;
import com.iticbcn.yerayreyes.model.Jugador;
import com.iticbcn.yerayreyes.model.Lliga;

public class ListAllData {
    
    static ClassificacioDAO classificacioDAO = new ClassificacioDAO();
    static EquipDAO equipDAO = new EquipDAO();
    static JugadorDAO jugadorDAO = new JugadorDAO();
    static LligaDAO lligaDAO = new LligaDAO();

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

        ArrayList<Jugador> jugadors = new ArrayList<>(jugadorDAO.findAll());
        if (jugadors.isEmpty()) {
            System.out.println("No hi ha jugadors per mostrar");
            System.exit(1);
        }

        System.out.println("Llista de Jugadors:");
        for (Jugador jugador : jugadors) {
            System.out.println(jugador.toString());
        }

    }

    public static void listEquip(){

        ArrayList<Equip> equips = new ArrayList<>(equipDAO.findAll());
        if (equips.isEmpty()) {
            System.out.println("No hi ha equips per mostrar");
            System.exit(1);
        }

        System.out.println("Llista d'Equips:");
        for (Equip equip : equips) {
            System.out.println(equip.toString());
        }
    }

    public static void listClassificacio(){

        ArrayList<Classificacio> classificacions = new ArrayList<>(classificacioDAO.findAll());
        if (classificacions.isEmpty()) {
            System.out.println("No hi ha classificacions per mostrar");
            System.exit(1);
        }

        System.out.println("Llista de Classificacions:");
        for (Classificacio classificacio : classificacions) {
            System.out.println(classificacio.toString());
        }

    }

    public static void listLliga(){

        ArrayList<Lliga> lligues = new ArrayList<>(lligaDAO.findAll());
        if (lligues.isEmpty()) {
            System.out.println("No hi ha lligues per mostrar");
            System.exit(1);
        }

        System.out.println("Llista de Lligues:");
        for (Lliga lliga : lligues) {
            System.out.println(lliga.toString());
        }

    }

}
