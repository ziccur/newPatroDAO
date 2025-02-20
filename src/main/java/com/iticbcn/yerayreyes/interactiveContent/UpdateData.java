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

public class UpdateData {

    static ClassificacioDAO classificacioDAO = new ClassificacioDAO();
    static EquipDAO equipDAO = new EquipDAO();
    static JugadorDAO jugadorDAO = new JugadorDAO();
    static LligaDAO lligaDAO = new LligaDAO();

    public static void updateData(int opcio){
        switch (opcio) {
            case 1 -> updateLliga();
            case 2 -> updateEquip();
            case 3 -> updateJugador();
            case 4 -> updateClassificacio();
            default -> {
                // Handle invalid option if necessary
            }
        }
    }
    
    public static void updateJugador(){

        ArrayList<Jugador> jugadors = new ArrayList<>(jugadorDAO.findAll());
        ArrayList<Equip> equips = new ArrayList<>(equipDAO.findAll());
        if (jugadors.isEmpty()) {
            System.out.println("No hi ha jugadors per actualitzar");
            System.exit(1);
        }

        System.err.println("Selecciona el ID del jugador que vols actualitzar:");
        for(Jugador jugador : jugadors){
            System.out.println(jugador.toString());
        }

        System.out.print("Id del jugador: ");
        int numJugador = Integer.parseInt(Entrada.readLine());

        for(Jugador jugador : jugadors){
            if(jugador.getIdJugador() == numJugador){
                System.out.println("Introdueix el nou nom del jugador:");
                String nom = Entrada.readLine();
                System.out.println("Introdueix el nou cognom del jugador:");
                String cognom = Entrada.readLine();
                System.out.println("Introdueix la ID del equip del jugador: (Actualment es " + jugador.getEquip().getIdEquip() + ")");
                for(Equip equip : equips){
                    System.out.println(equip.toString());
                }
                System.out.print("Id de l'equip: ");
                int idEquip = Integer.parseInt(Entrada.readLine());
                
                for(Equip equip : equips){
                    if(equip.getIdEquip() == idEquip){
                        jugador.setNom(nom);
                        jugador.setCognoms(cognom);
                        jugador.setEquip(equip);
                        jugadorDAO.update(jugador);
                        System.out.println("Jugador actualitzat correctament");
                        break;
                    }
                }
                return;
            }
        }

    }

    public static void updateEquip(){

        ArrayList<Equip> equips = new ArrayList<>(equipDAO.findAll());
        ArrayList<Lliga> lligues = new ArrayList<>(lligaDAO.findAll());
        if (equips.isEmpty()) {
            System.out.println("No hi ha equips per actualitzar");
            System.exit(1);
        }

        System.err.println("Selecciona el ID de l'equip que vols actualitzar:");
        for(Equip equip : equips){
            System.out.println(equip.toString());
        }

        System.out.print("Id de l'equip: ");
        int numEquip = Integer.parseInt(Entrada.readLine());

        for(Equip equip : equips){
            if(equip.getIdEquip() == numEquip){
                System.out.println("Introdueix el nou nom de l'equip:");
                String nom = Entrada.readLine();
                System.out.println("Introdueix la nova ciutat de l'equip:");
                String ciutat = Entrada.readLine();
                System.out.println("Introdueix la nova ID de la lliga de l'equip: (Actualment es " + equip.getLliga().getIdLliga() + ")");
                for(Lliga lliga : lligues){
                    System.out.println(lliga.toString());
                }
                System.out.print("Id de la lliga: ");
                int idLliga = Integer.parseInt(Entrada.readLine());
                for(Lliga lliga : lligues){
                    if(lliga.getIdLliga() == idLliga){
                        equip.setNomEquip(nom);
                        equip.setCiutat(ciutat);
                        equip.setLliga(lliga);
                        equipDAO.update(equip);
                        System.out.println("Equip actualitzat correctament");
                        break;
                    }
                }
                return;
            }
        }

    }

    public static void updateClassificacio(){

        ArrayList<Classificacio> classificacions = new ArrayList<>(classificacioDAO.findAll());
        ArrayList<Equip> equips = new ArrayList<>(equipDAO.findAll());

        if (classificacions.isEmpty()) {
            System.out.println("No hi ha classificacions per actualitzar");
            System.exit(1);
        }

        System.err.println("Selecciona el ID de la classificacio que vols actualitzar:");
        for(Classificacio classificacio : classificacions){
            System.out.println(classificacio.toString());
        }

        System.out.print("Id de la classificacio: ");
        int numClassificacio = Integer.parseInt(Entrada.readLine());

        for(Classificacio classi : classificacions){
            if(classi.getIdClassificacio() == numClassificacio){
                System.out.println("Introdueix el nou punts de la classificacio:");
                int punts = Integer.parseInt(Entrada.readLine());
                System.out.println("Introdueix el nou partits jugats de la classificacio:");
                int partitsJugats = Integer.parseInt(Entrada.readLine());
                System.out.println("Introdueix el nou victories de la classificacio:");
                int victories = Integer.parseInt(Entrada.readLine());
                System.out.println("Introdueix la nova ID de l'equip de la classificacio: (Actualment es " + classi.getEquip().getIdEquip() + ")");
                for(Equip equip : equips){
                    System.out.println(equip.toString());
                }
                System.out.print("Id de l'equip: ");
                int idEquip = Integer.parseInt(Entrada.readLine());
                for(Equip equip : equips){
                    if(equip.getIdEquip() == idEquip){
                        classi.setPunts(punts);
                        classi.setPartitsJugats(partitsJugats);
                        classi.setVictories(victories);
                        classi.setEquip(equip);
                        classificacioDAO.update(classi);
                        System.out.println("Classificacio actualitzada correctament");
                        break;
                    }
                }
            }
        }
    }

    public static void updateLliga(){

        ArrayList<Lliga> lligues = new ArrayList<>(lligaDAO.findAll());
        
        System.out.println("Selecciona el ID de la lliga que vols actualitzar:");
        for(Lliga lliga : lligues){
            System.out.println(lliga.toString());
        }

        System.out.print("Id de la lliga: ");
        int numLliga = Integer.parseInt(Entrada.readLine());

        for(Lliga lliga : lligues){
            if(lliga.getIdLliga() == numLliga){
                System.out.println("Introdueix el nou nom de la lliga:");
                String nom = Entrada.readLine();
                System.out.println("Introdueix la nova temporada de la lliga:");
                String temporada = Entrada.readLine();
                lliga.setNomLliga(nom);
                lliga.setTemporada(temporada);
                lligaDAO.update(lliga);
                System.out.println("Lliga actualitzada correctament");
                return;
            }
        }

    }
}
