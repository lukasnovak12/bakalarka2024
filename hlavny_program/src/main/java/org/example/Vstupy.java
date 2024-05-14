package org.example;

import java.util.Scanner;

public class Vstupy {
    double aPociatok;
    double bPociatok;
    double aH;
    double aD;
    double bH;
    double bD;
    double rf;
    double m;
    double x0=0;
    double y0=0;
    double z0=0;
    String input;
    public Vstupy() {

        // Uvítacie privítanie
        System.out.println("Vitajte v programe na vyhodnotenie podmienok investícií do akcii a dlhopisov.");
        System.out.println("Po stlačení Enter začnite zadávať hodnoty.");
        Scanner scanner = new Scanner(System.in);
        // Čakanie na stlačenie Enter
        scanner.nextLine();

        aPociatok = Validacia.validaciaVstupovA(scanner, "Zadajte počiatočnú hodnotu akcie A pred udalosťami:");
        bPociatok = Validacia.validaciaVstupovA(scanner, "Zadajte počiatočnú hodnotu akcie B pred udalosťami:");
        aH = Validacia.validaciaVstupovA(scanner, "Zadajte hodnotu premennej aH:");
        aD = Validacia.validaciaVstupovA(scanner, "Zadajte hodnotu premennej aD:");
        bH = Validacia.validaciaVstupovA(scanner, "Zadajte hodnotu premennej bH:");
        bD = Validacia.validaciaVstupovA(scanner, "Zadajte hodnotu premennej bD:");
        rf = Validacia.validaciaVstupovA(scanner, "Zadajte hodnotu premennej rf:");
        m = Validacia.validaciaVstupovA(scanner, "Zadajte hodnotu premennej m:");

        System.out.println("Chcete si zadať premenné x0,y0,z0 svoje, alebo chcete aby ich program vygeneroval ?\n" +
                "Pokiaľ áno stlačte 'y' pokiaľ nie stlačte 'n'. ");
        input=scanner.next();
        while (!input.equals("y") && !input.equals("n") ){
            System.out.println("Neplatná odpoveď ! Zadajte odpoveď znova:");
            input= scanner.next();
        }
        if (input.equals("n")) {
            y0 = Validacia.validaciaVstupovB(scanner, "Zadajte hodnotu počtu akcií B, ktoré vlastníte v čase 0:");
            x0 = Validacia.validaciaVstupovB(scanner, "Zadajte hodnotu počtu akcií A, ktoré vlastníte v čase 0:");
            z0 = Validacia.validaciaVstupovB(scanner, "Zadajte hodnotu počtu dlhopisov, ktoré vlastníte v čase 0:");
        }
    }

    public double getaPociatok() {
        return aPociatok;
    }

    public double getbPociatok() {
        return bPociatok;
    }

    public double getaH() {
        return aH;
    }

    public double getaD() {
        return aD;
    }

    public double getbH() {
        return bH;
    }

    public double getbD() {
        return bD;
    }

    public double getRf() {
        return rf;
    }

    public double getM() {
        return m;
    }

    public double getX0() {
        return x0;
    }


    public double getY0() {
        return y0;
    }

    public double getZ0() {
        return z0;
    }

    public String getInput() {
        return input;
    }
}
