package com.iticbcn.yerayreyes.interactiveContent;

import java.util.ArrayList;

import org.hibernate.SessionFactory;

import com.iticbcn.yerayreyes.Entrada;
import com.iticbcn.yerayreyes.HibernateUtil;
import com.iticbcn.yerayreyes.dao.ClassificacioDAO;
import com.iticbcn.yerayreyes.dao.EquipDAO;
import com.iticbcn.yerayreyes.dao.JugadorDAO;
import com.iticbcn.yerayreyes.dao.LligaDAO;
import com.iticbcn.yerayreyes.model.Classificacio;
import com.iticbcn.yerayreyes.model.Equip;
import com.iticbcn.yerayreyes.model.Jugador;
import com.iticbcn.yerayreyes.model.Lliga;

public class DeleteData {

    static SessionFactory session = HibernateUtil.getSessionFactory();

    static ClassificacioDAO classificacioDAO = new ClassificacioDAO(session);
    static EquipDAO equipDAO = new EquipDAO(session);
    static JugadorDAO jugadorDAO = new JugadorDAO(session);
    static LligaDAO lligaDAO = new LligaDAO(session);

    public static void eliminarData(int opcio){
        System.out.println("############################");
        switch (opcio) {
            case 1 -> eliminarLliga();
            case 2 -> eliminarEquip();
            case 3 -> eliminarJugador();
            case 4 -> eliminarClassificacio();
        }
    }
    
    public static void eliminarJugador(){
        try {
            
        
            ArrayList<Jugador> jugadors = new ArrayList<>(jugadorDAO.getAll());
            if (jugadors.isEmpty()) {
                System.out.println("No hi ha jugadors per eliminar");
                System.exit(1);
            }

            System.err.println("Selecciona el ID del jugador que vols eliminar:");
            
            for (int i = 0; i < jugadors.size(); i++) {
                System.out.println(jugadors.get(i).toString());
            }

            System.out.print("Id del jugador: ");
            int numJugador = Integer.parseInt(Entrada.readLine());

            for(Jugador jugador : jugadors){
                if(jugador.getIdJugador() == numJugador){
                    jugadorDAO.delete(jugadorDAO.get(numJugador));
                    System.out.println("Jugador eliminat correctament");
                    return;
                }
            }
        

            System.out.println("No s'ha trobat el jugador amb ID " + numJugador);
        } catch (Exception e) {
            System.err.println("Error: Has d'introduir un número");
        }
    }

    public static void eliminarEquip(){

        try{

            ArrayList<Equip> equips = new ArrayList<>(equipDAO.getAll());
            if (equips.isEmpty()) {
                System.out.println("No hi ha equips per eliminar");
                return;
            }
            
            System.out.println("Selecciona el ID de l'equip que vols eliminar:");
            
            for (int i = 0; i < equips.size(); i++) {
                System.out.println(equips.get(i).toString());
            }

            System.out.print("Id de l'equip: ");
            int numEquip = Integer.parseInt(Entrada.readLine());

            for(Equip equip : equips){
                if(equip.getIdEquip() == numEquip){
                    equipDAO.delete(equipDAO.get(numEquip));
                    System.out.println("Equip eliminat correctament");
                    return;
                }
            }

            System.err.println("No s'ha trobat l'equip amb ID " + numEquip);
        } catch (Exception e) {
            System.err.println("Error: Has d'introduir un número");

        }
    }

    public static void eliminarClassificacio(){

        try{

            ArrayList<Classificacio> classificacions = new ArrayList<>(classificacioDAO.getAll());
            if (classificacions.isEmpty()) {
                System.out.println("No hi ha classificacions per eliminar");
                return;
            }
            
            System.out.println("Selecciona el ID de la classificacio que vols eliminar:");
            for(Classificacio classificacio : classificacions){
                System.out.println(classificacio.toString());
            }

            System.out.print("Id de la classificacio: ");
            int numClassificacio = Integer.parseInt(Entrada.readLine());

            for(Classificacio classificacio : classificacions){
                if(classificacio.getIdClassificacio() == numClassificacio){
                    classificacioDAO.delete(classificacioDAO.get(numClassificacio));
                    System.out.println("Classificacio eliminada correctament");
                    return;
                }
            }

            System.err.println("No s'ha trobat la classificacio amb ID " + numClassificacio);

        } catch (Exception e) {
            System.err.println("Error: Has d'introduir un número");
        }

    }

    public static void eliminarLliga(){

        try{
            ArrayList<Lliga> lligues = new ArrayList<>(lligaDAO.getAll());
            if (lligues.isEmpty()) {
                System.out.println("No hi ha lligues per eliminar");
                return;
            }

            System.out.println("Selecciona el ID de la lliga que vols eliminar:");

            for(Lliga lliga : lligues){
                System.out.println(lliga.toString());
            }

            System.out.print("Id de la lliga: ");
            int numLliga = Integer.parseInt(Entrada.readLine());

            for(Lliga lliga : lligues){
                if(lliga.getIdLliga() == numLliga){
                    lligaDAO.delete(lligaDAO.get(numLliga));
                    System.out.println("Lliga eliminada correctament");
                    return;
                }
            }

            System.err.println("No s'ha trobat la lliga amb ID " + numLliga);
        } catch (Exception e) {
            System.err.println("Error: Has d'introduir un número");
        }
    }

}
