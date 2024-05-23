package org.example;

import java.util.Scanner;

public class Validacia {


    public static double validaciaVstupov(Scanner scanner, String message, boolean moznost, double... pociatok) {
        double input=0;
        boolean validnyVstup = false;
        double initial = pociatok.length > 0 ? pociatok[0] : 0;
        do {
            System.out.println(message);
            String vstup = scanner.next();
            try {
                input = Double.parseDouble(vstup);
                if (moznost && input < 0) {
                    System.out.println("Hodnota nemôže byť záporná. Zadajte ju znova.");
                } else if (!moznost && input > 0) {
                    System.out.println("Hodnota nemôže byť kladná. Zadajte ju znova.");
                } else if (pociatok.length > 0 && input > initial * 2) {
                System.out.println("Hodnota je viac ako dvojnásobok pôvodnej hodnoty. Zadajte ju znova.");
                }else {
                    validnyVstup = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatný vstup! Zadajte číslo.");
            }
        } while (!validnyVstup);

        return input;
    }
}
