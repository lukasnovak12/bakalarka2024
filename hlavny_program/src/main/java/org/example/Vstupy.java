package org.example;

import java.util.*;

public class Vstupy {
    double aPociatok;
    double bPociatok;
    double aH;
    double aD;
    double bH;
    double bD;
    double rf;
    double m;
    double x0;
    double y0;
    double z0;
    String input;
    public Vstupy() {
        Scanner scanner = new Scanner(System.in);
        //zadavanie pociatocnych hodnot, pred zapisanim hodnoty do premenej je najprv uskutocnena validacia hodnoty
        aPociatok = Validacia.validaciaVstupov(scanner, "Zadajte počiatočnú hodnotu akcie A pred udalosťami:",true,0);
        bPociatok = Validacia.validaciaVstupov(scanner, "Zadajte počiatočnú hodnotu akcie B pred udalosťami:",true,0);
        aH = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej aH:",true,0,aPociatok);
        aD = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej aD:",true,0,aPociatok);
        bH = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej bH:",true,0,bPociatok);
        bD = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej bD:",true,0,bPociatok);
        rf = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej rf:",true,0);
        //otazka, ci chceme alebo nechceme vygenerovat hodnoty pociatocnych investicii v akciach a dlhopisoch
        System.out.println("Chcete si zadať premenné m,x0,y0,z0 svoje, alebo chcete aby ich program vygeneroval ?\n" +
                "Pokiaľ áno stlačte 'y' pokiaľ nie stlačte 'n'. ");
        input=scanner.next();

        while (!input.equals("y") && !input.equals("n") ){
            System.out.println("Neplatná odpoveď ! Zadajte odpoveď znova:");
            input= scanner.next();
        }

        if (input.equals("n")) {
            m = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej m:",true,0);
            x0 = Validacia.validaciaVstupov(scanner, "Zadajte, koľko finančných prostriedkov máte v čase 0 v akcií A:",false,m);
            y0 = Validacia.validaciaVstupov(scanner, "Zadajte, koľko koľko finančných prostriedkov máte v čase 0 v akcií B:",false,m);
            z0 = Validacia.validaciaVstupov(scanner, "Zadajte , koľko si dokážete emitáciou dlhopisov v čase 0 požičať:",false,m);
        }
    }
    //gettery a settery
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
