package com.iticbcn.yerayreyes;

import com.iticbcn.yerayreyes.interactiveContent.CreateData;
import com.iticbcn.yerayreyes.interactiveContent.DeleteData;
import com.iticbcn.yerayreyes.interactiveContent.ListAllData;
import com.iticbcn.yerayreyes.interactiveContent.ReadData;
import com.iticbcn.yerayreyes.interactiveContent.UpdateData;
public class Main {
    public static void main(String[] args) {

        System.out.println("############################");
        System.out.println("##  Selecciona una opció  ##");
        System.out.println("############################\n");
        System.out.println("1. Gestionar Lliga");
        System.out.println("2. Gestionar Equip");
        System.out.println("3. Gestionar Jugador");
        System.out.println("4. Gestionar Classificació");
        System.out.println("5. Sortir");
        System.out.println("############################\n");
        System.out.print("Opció: ");
        int opcio;

        try {
            opcio = Integer.parseInt(Entrada.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Has d'introduir un número");
            return;
        }

        if (opcio < 1 || opcio > 5) {
            System.out.println("Error: Has d'introduir un número entre 1 i 5");
            return;
        }

        String escollida;

        switch (opcio) {
            case 1 -> {
                escollida = "Lliga";            }
            case 2 -> {
                escollida = "Equip";
            }
            case 3 -> {
                escollida = "Jugador";
            }
            case 4 -> {
                escollida = "Classificació";
            }
            case 5 -> {
                System.out.println("Sortint...");
                return;
            }
            default -> throw new AssertionError();
        }    
        int opcio2;
        System.out.println("############################");
        System.out.printf(" 1.  Crear %s\n", escollida);
        System.out.printf(" 2.  Modificar %s\n", escollida);
        System.out.printf(" 3.  Eliminar %s\n", escollida);
        System.out.printf(" 4.  Consultar %s\n", escollida);
        System.out.printf(" 5.  Llistar %s\n", escollida);
        System.out.println("############################");
        System.out.print("Opció: ");

        try {
            opcio2 = Integer.parseInt(Entrada.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Has d'introduir un número valid");
            return;
        }

        if (opcio2 < 1 || opcio2 > 5) {
            System.out.println("Error: Has d'introduir un número entre 1 i 5");
            return;
        }

        switch (opcio2) {
            case 1 -> {
                System.out.println("Has escollit crear\n");
                CreateData.crearData(opcio);
            }
            case 2 -> {
                System.out.println("Has escollit modificar");
                UpdateData.updateData(opcio);
            }
            case 3 -> {
                System.out.println("Has escollit eliminar");
                DeleteData.eliminarData(opcio);
            }
            case 4 -> {
                System.out.println("Has escollit consultar");
                ReadData.readData(opcio);
            }
            case 5 -> {
                System.out.println("Has escollit llistar");
                ListAllData.listAllData(opcio);
            }
            default -> throw new AssertionError();
        }

    }
}