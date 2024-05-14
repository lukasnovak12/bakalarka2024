package org.example;

public class Vysledky {
    private final double vysledok1;
    private final double vysledok2;

    public Vysledky(double result1, double result2) {
        this.vysledok1 = result1;
        this.vysledok2 = result2;
    }

    public double getVysledok1() {
        return vysledok1;
    }

    public double getVysledok2() {
        return vysledok2;
    }

}
