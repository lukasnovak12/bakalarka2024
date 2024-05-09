package org.example;

import java.util.Scanner;

public class Validacia {

    public static double validaciaVstupov(Scanner scanner, String message) {
        double input;
        do {
            System.out.println(message);
            input = scanner.nextDouble();

            if (input < 0) {
                System.out.println("Hodnota nemôže byť záporná. Zadajte ju znova.");
            }
        } while (input < 0);
        return input;
    }

    public static double validaciaVstupovCasNula(Scanner scanner, String message) {
        double input;
        do {
            System.out.println(message);
            input = scanner.nextDouble();

            if (input > 0) {
                System.out.println("Hodnota nemôže byť kladná. Zadajte ju znova.");
            }
        } while (input > 0);
        return input;
    }
}
