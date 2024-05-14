package org.example;

import java.util.Scanner;

public class Validacia {

    public static double validaciaVstupovA(Scanner scanner, String message) {
        double input=0;
        boolean validnyVstup = false;

        do {
            System.out.println(message);
            String vstup = scanner.nextLine();

            try {
                input = Double.parseDouble(vstup);
                if (input < 0) {
                    System.out.println("Hodnota nemôže byť záporná. Zadajte ju znova.");
                } else {
                    validnyVstup = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatný vstup! Zadajte číslo.");
            }
        } while (!validnyVstup);

        return input;
    }

    public static double validaciaVstupovB(Scanner scanner, String message) {
        double vstup;
        do {
            System.out.println(message);
            vstup = scanner.nextDouble();

            if (vstup > 0) {
                System.out.println("Hodnota nemôže byť kladná. Zadajte ju znova.");
            }
        } while (vstup > 0);
        return vstup;
    }
}
