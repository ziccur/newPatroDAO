package com.iticbcn.yerayreyes.interactiveContent;

import java.util.ArrayList;

import com.iticbcn.yerayreyes.Entrada;
import com.iticbcn.yerayreyes.dao.ClassificacioDAO;
import com.iticbcn.yerayreyes.dao.EquipDAO;
import com.iticbcn.yerayreyes.dao.JugadorDAO;
import com.iticbcn.yerayreyes.dao.LligaDAO;
import com.iticbcn.yerayreyes.model.Classificacio;
import com.iticbcn.yerayreyes.model.Equip;
import com.iticbcn.yerayreyes.model.Jugador;
import com.iticbcn.yerayreyes.model.Lliga;

public class CreateData {

    static ClassificacioDAO classificacioDAO = new ClassificacioDAO();
    static EquipDAO equipDAO = new EquipDAO();
    static JugadorDAO jugadorDAO = new JugadorDAO();
    static LligaDAO lligaDAO = new LligaDAO();
                
    public static void crearData(int opcio){
        System.out.println("############################");
        switch (opcio) {
            case 1 -> crearLliga();
            case 2 -> crearEquip();
            case 3 -> crearJugador();
            case 4 -> crearClassificacio();
        }
    }
                    
    public static void crearJugador(){
        String nom;
        String cognom;

        System.out.println("Introdueix el nom del jugador:");
        nom = Entrada.readLine();
        System.out.println("Introdueix el cognom del jugador:");
        cognom = Entrada.readLine();
        System.out.println("Introdueixi el número de l'equip del jugador:");
                        
        ArrayList<Equip> equips = (ArrayList<Equip>) equipDAO.findAll();
        if (equips.isEmpty()) {
            System.out.println("Primer crea un equip");
            System.exit(1);
        }

        for (int i = 0; i < equips.size(); i++) {
            System.out.println(equips.get(i).toString());
        }
                        
        System.out.print("Id de l'equip: ");
        int numEquip = Integer.parseInt(Entrada.readLine());

        for(Equip equip : equips){
            if(equip.getIdEquip() == numEquip){
                jugadorDAO.create(new Jugador(nom, cognom, equip));
                System.out.println("Jugador creat correctament");
                return;
            }
        }

        System.out.println("No s'ha trobat l'equip amb aquest número");
        System.exit(1);
    }
        
    public static void crearEquip(){
        String nom;
        String ciutat;
        Lliga lliga;

        System.out.println("Introdueix el nom de l'equip:");
        nom = Entrada.readLine();
        System.out.println("Introdueix la ciutat de l'equip:");
        ciutat = Entrada.readLine();
        System.out.println("Introdueixi el Id de la lliga de l'equip:");

        ArrayList<Lliga> lligues = (ArrayList<Lliga>) lligaDAO.findAll();
        if (lligues.isEmpty()) {
            System.out.println("Primer crea una lliga");
            System.exit(1);
        }

        for (int i = 0; i < lligues.size(); i++) {
            System.out.println(lligues.get(i).toString());
        }

        System.out.print("Id de la lliga: ");
        int numLliga = Integer.parseInt(Entrada.readLine());

        for(Lliga lligaAux : lligues){
            if(lligaAux.getIdLliga() == numLliga){
                equipDAO.create(new Equip(nom, ciutat, lligaAux));
                System.out.println("Equip creat correctament");
                return;
            }
        }

    }

    public static void crearClassificacio(){
        Integer punts;
        Integer partitsJugats;
        Integer victories;

        System.out.println("Introdueixi el número d'Id de l'equip de la classificació:");
        ArrayList<Equip> equips = (ArrayList<Equip>) equipDAO.findAll();
        if (equips.isEmpty()) {
            System.out.println("Primer crea un equip");
            System.exit(1);
        }

        for (int i = 0; i < equips.size(); i++) {
            System.out.println(equips.get(i).toString());
        }

        System.out.print("Id de l'equip: ");
        int numEquip = Integer.parseInt(Entrada.readLine());

        boolean equipValid = false;
        for(Equip equipAux : equips){
            if(equipAux.getIdEquip() == numEquip){
                equipValid = true;
            }
        }
        if(equipValid == false){System.exit(1);}

        System.out.println("Introdueixi el número de punts de l'equip:");
        punts = Integer.parseInt(Entrada.readLine());
        System.out.println("Introdueixi el número de partits jugats de l'equip:");
        partitsJugats = Integer.parseInt(Entrada.readLine());
        System.out.println("Introdueixi el número de victories de l'equip:");
        victories = Integer.parseInt(Entrada.readLine());

        try {
            classificacioDAO.create(new Classificacio(equipDAO.findById(numEquip), punts, partitsJugats, victories));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.err.println("Classificació creada correctament");        
    }

    public static void crearLliga(){
        String nomLliga;
        String temporada;
        
        System.out.println("Introdueix el nom de la lliga:");
        nomLliga = Entrada.readLine();
        System.out.println("Introdueix la temporada de la lliga:");
        temporada = Entrada.readLine();
        
        lligaDAO.create(new Lliga(nomLliga, temporada));
        System.out.println("Lliga creada correctament");
    }

}
