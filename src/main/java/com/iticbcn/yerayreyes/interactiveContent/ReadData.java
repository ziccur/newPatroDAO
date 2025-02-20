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

public class ReadData {

    static ClassificacioDAO classificacioDAO = new ClassificacioDAO();
    static EquipDAO equipDAO = new EquipDAO();
    static JugadorDAO jugadorDAO = new JugadorDAO();
    static LligaDAO lligaDAO = new LligaDAO();

    @SuppressWarnings("empty-statement")
    public static void readData(int opcio){
        System.out.println("############################");
        switch (opcio) {
            case 1 -> readLliga();
            case 2 -> readEquip();
            case 3 -> readJugador();
            case 4 -> readClassificacio();
        };
    }
    
    public static void readJugador(){
        
        System.out.println("Estas buscant un jugador");
        System.out.println("Solecciona per quin camp vols buscar el jugador:");
        System.out.println("############################");
        System.out.println("1. Nom");
        System.out.println("2. Cognom");
        System.out.println("3. Equip");
        System.out.println("4. Per ID");
        System.out.println("############################");
        System.out.print("Opcio: ");
        int opcio = Integer.parseInt(Entrada.readLine());

        ArrayList<Jugador> jugadors = new ArrayList<>(jugadorDAO.findAll());

        switch (opcio){
            case 1 -> {
                System.out.print("Nom del jugador: ");
                String nom = Entrada.readLine();

                for(Jugador jugador : jugadors){
                    if(jugador.getNom().equalsIgnoreCase(nom)){
                        System.out.println(jugador.toString());
                        return;
                    }
                }

                System.out.println("No s'ha trobat cap jugador amb el nom " + nom);
            }

            case 2 -> {
                System.out.print("Cognom del jugador: ");
                String cognom = Entrada.readLine();

                for(Jugador jugador : jugadors){
                    if(jugador.getCognoms().equalsIgnoreCase(cognom)){
                        System.out.println(jugador.toString());
                        return;
                    }
                }
                System.out.println("No s'ha trobat cap jugador amb el cognom " + cognom);
            }

            case 3 -> {
                ArrayList<Equip> equips = new ArrayList<>(equipDAO.findAll());
                System.out.println("Selecciona el ID d'un equip de la llista:");

                for(Equip equip : equips){
                    System.out.println(equip.toString());
                }

                System.out.print("Id de l'equip: ");
                int idEquip = Integer.parseInt(Entrada.readLine());

                for(Jugador jugador : jugadors){
                    if(jugador.getEquip().getIdEquip() == idEquip){
                        System.out.println(jugador.toString());
                    }
                }
            }

            case 4 -> {
                System.out.print("Id del jugador: ");
                int idJugador = Integer.parseInt(Entrada.readLine());

                for(Jugador jugador : jugadors){
                    if(jugador.getIdJugador() == idJugador){
                        System.out.println(jugador.toString());
                        return;
                    }
                }

                System.out.println("No s'ha trobat cap jugador amb l'ID " + idJugador);
            }
            default -> System.out.println("Opció no vàlida");
        }


    }

    public static void readEquip(){

        ArrayList<Equip> equips = new ArrayList<>(equipDAO.findAll());

        System.out.println("Estas buscant un equip");
        System.out.println("Solecciona per quin camp vols buscar l'equip:");
        System.out.println("############################");
        System.out.println("1. Nom");
        System.out.println("2. Ciutat");
        System.out.println("3. Per ID");
        System.out.println("4. Per lliga");
        System.out.println("############################");
        System.out.print("Opcio: ");
        int opcio = Integer.parseInt(Entrada.readLine());

        switch (opcio){
            case 1 -> {
                System.out.print("Nom de l'equip: ");
                String nom = Entrada.readLine();

                for(Equip equip : equips){
                    if(equip.getNomEquip().equalsIgnoreCase(nom)){
                        System.out.println(equip.toString());
                        return;
                    }
                }

                System.out.println("No s'ha trobat cap equip amb el nom " + nom);
            }

            case 2 -> {
                System.out.print("Ciutat de l'equip: ");
                String ciutat = Entrada.readLine();

                for(Equip equip : equips){
                    if(equip.getCiutat().equalsIgnoreCase(ciutat)){
                        System.out.println(equip.toString());
                        return;
                    }
                }

                System.out.println("No s'ha trobat cap equip amb la ciutat " + ciutat);
            }

            case 3 -> {
                System.out.print("Id de l'equip: ");
                int idEquip = Integer.parseInt(Entrada.readLine());

                for(Equip equip : equips){
                    if(equip.getIdEquip() == idEquip){
                        System.out.println(equip.toString());
                        return;
                    }
                }

                System.out.println("No s'ha trobat cap equip amb l'ID " + idEquip);
            }

            case 4 -> {
                ArrayList<Lliga> lligues = new ArrayList<>(lligaDAO.findAll());
                System.out.println("Selecciona el ID d'una lliga de la llista:");
                for(Lliga lliga : lligues){
                    System.out.println(lliga.toString());
                }

                System.out.print("Id de la lliga: ");
                int idLliga = Integer.parseInt(Entrada.readLine());

                for(Equip equip : equips){
                    if(equip.getLliga().getIdLliga() == idLliga){
                        System.out.println(equip.toString());
                    }
                }
            }

            default -> System.out.println("Opció no vàlida");
        }

    }

    public static void readClassificacio(){

        ArrayList<Classificacio> classificacions = new ArrayList<>(classificacioDAO.findAll());
        System.out.println("Estas buscant una classificacio");
        System.out.println("Solecciona per quin camp vols buscar la classificacio:");
        System.out.println("############################");
        System.out.println("1. Equip");
        System.out.println("2. Per ID");
        System.out.println("############################");
        System.out.print("Opcio: ");
        int opcio = Integer.parseInt(Entrada.readLine());

        switch (opcio){
            case 1 -> {
                ArrayList<Equip> equips = new ArrayList<>(equipDAO.findAll());
                System.out.println("Selecciona el ID d'un equip de la llista:");
                for(Equip equip : equips){
                    System.out.println(equip.toString());
                }

                System.out.print("Id de l'equip: ");
                int idEquip = Integer.parseInt(Entrada.readLine());

                for(Classificacio classificacio : classificacions){
                    if(classificacio.getEquip().getIdEquip() == idEquip){
                        System.out.println(classificacio.toString());
                    }
                }
            }

            case 2 -> {
                System.out.print("Id de la classificacio: ");
                int idClassificacio = Integer.parseInt(Entrada.readLine());

                for(Classificacio classificacio : classificacions){
                    if(classificacio.getIdClassificacio() == idClassificacio){
                        System.out.println(classificacio.toString());
                        return;
                    }
                }
                System.out.println("No s'ha trobat cap classificacio amb l'ID " + idClassificacio);
            }

            default -> System.out.println("Opció no vàlida");
        }

    }

    public static void readLliga(){

        ArrayList<Lliga> lligues = new ArrayList<>(lligaDAO.findAll());
        
        System.out.println("Estas buscant una lliga");
        System.out.println("Solecciona per quin camp vols buscar la lliga:");
        System.out.println("############################");
        System.out.println("1. Nom");
        System.out.println("2. Temporada");
        System.out.println("3. Per ID");
        System.out.println("############################");
        System.out.print("Opcio: ");
        int opcio = Integer.parseInt(Entrada.readLine());

        switch (opcio){
            case 1 -> {
                System.out.print("Nom de la lliga: ");
                String nom = Entrada.readLine();

                for(Lliga lliga : lligues){
                    if(lliga.getNomLliga().equalsIgnoreCase(nom)){
                        System.out.println(lliga.toString());
                        return;
                    }
                }

                System.out.println("No s'ha trobat cap lliga amb el nom " + nom);
            }

            case 2 -> {
                System.out.print("Temporada de la lliga: ");
                String temporada = Entrada.readLine();

                for(Lliga lliga : lligues){
                    if(lliga.getTemporada().equalsIgnoreCase(temporada)){
                        System.out.println(lliga.toString());
                        return;
                    }
                }

                System.out.println("No s'ha trobat cap lliga amb la temporada " + temporada);
            }

            case 3 -> {
                System.out.print("Id de la lliga: ");
                int idLliga = Integer.parseInt(Entrada.readLine());

                for(Lliga lliga : lligues){
                    if(lliga.getIdLliga() == idLliga){
                        System.out.println(lliga.toString());
                        return;
                    }
                }

                System.out.println("No s'ha trobat cap lliga amb l'ID " + idLliga);
            }

            default -> System.out.println("Opció no vàlida");
        }

    }
}
