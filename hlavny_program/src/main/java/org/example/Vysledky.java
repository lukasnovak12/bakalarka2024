package org.example;

public class Vysledky {
    private final double vysledok1;
    private final double vysledok2;
    private final double vysledok3;


    public Vysledky(double vysledok1, double vysledok2, double vysledok3) {
        this.vysledok1 = vysledok1;
        this.vysledok2 = vysledok2;
        this.vysledok3 = vysledok3;
    }

    public double getVysledok3() {
        return vysledok3;
    }

    public double getVysledok1() {
        return vysledok1;
    }

    public double getVysledok2() {
        return vysledok2;
    }

}
