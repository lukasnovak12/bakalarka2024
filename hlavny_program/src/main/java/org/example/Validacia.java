package org.example;

import java.util.Scanner;

public class Validacia {


    public static double validaciaVstupov(Scanner scanner, String message, boolean moznost, double... pociatok) {
        double input=0;
        boolean validnyVstup = false;
        double initial = pociatok.length > 0 ? pociatok[0] : 0;//dobrovolny argument v metode, ktory zarucuje aby buduca hodnota akcie neblo 2* hodnoty povodnej ceny akcie
        do {
            System.out.println(message);
            String vstup = scanner.next();
            try {
                input = Double.parseDouble(vstup);
                if (moznost && input < 0) { // hodnota moznost=true , ci sa jedna o premene aPociatok, bPociatok, ah,bh,ad,bd rf a m , ktore musia byt za kazdych okolnosti kladne
                    System.out.println("Hodnota nemôže byť záporná. Zadajte ju znova.");
                } else if (!moznost && input > 0) { // pokial moznost=false tak zadavame hodnoty pre x0,z0,y0 ktore musia byt zaporne.
                    System.out.println("Hodnota nemôže byť kladná. Zadajte ju znova.");
                } else if (pociatok.length > 0 && input > initial * 2) { // pokial bol zadany dobrovolny argument podmienka kontroluje nasobky cien. sluzi pre ah, bh, bh a bd
                System.out.println("Hodnota je viac ako dvojnásobok pôvodnej hodnoty. Zadajte ju znova.");
                }else {
                    validnyVstup = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatný vstup! Zadajte číslo.");
            }
        } while (!validnyVstup);//opakuje pokial validnyVstup =true

        return input;
    }
}
