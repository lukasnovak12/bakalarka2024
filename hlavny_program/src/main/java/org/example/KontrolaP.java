package org.example;

public class KontrolaP {
    public static boolean kontrolaPodmienok(double aH, double aD, double bH, double bD, double rf) {
        boolean predpoklad1 = (aH - bH < 0 && 0 < aD - bD);//predpoklad 5 z teoretickej casti prace
        boolean predpoklad2 = (aH - bH > 0 && 0 > aD - bD);//predpoklad 6 z teoretickej casti prace
        boolean b = predpoklad1 || predpoklad2;
        // Kontrola podmienok
        if ((aH > 1 + rf && 1 + rf > 1 && 1 > aD) && (bH < 1 && 1 < 1 + rf && 1 + rf < bD)) {//predpoklad 1
            // Akcia pre podmienku 1
            System.out.println("Podmienka 1 bola splnená. Vykonávam akciu pre podmienku 1.");
            return true;
        } else if ((aH < 1 && 1 < 1 + rf && 1 + rf < aD) && (bH > 1 + rf && 1 + rf > 1 && 1 > bD)) {//predpoklad 2
            // Akcia pre podmienku 2
            System.out.println("Podmienka 2 bola splnená. Vykonávam akciu pre podmienku 2.");
            return true;
        } else if ((aH > 1 + rf && 1 + rf > 1 && 1 > aD) && (bH > 1 + rf && 1 + rf > 1 && 1 > bD)) {//predpoklad 3
            // Akcia pre podmienku 3
            if (!b && (aH != bH && aD != bD)) {//predpoklad 5 a 6
                System.out.println("Pri vstupoch, ktoré boli zadané, bola porušená podmienka nadmerného " +
                        "vychýlenia z trhovej rovnováhy. Zadajte hodnoty odznova.");
                return false;
            }
            System.out.println("Podmienka 3 bola splnená. Vykonávam akciu pre podmienku 3.");
            return true;
        } else if ((aH < 1 && 1 < 1 + rf && 1 + rf < aD) && (bH < 1 && 1 < 1 + rf && 1 + rf < bD)) {//predpoklad 4
            // Akcia pre podmienku 4
            if(!b && (aH != bH && aD != bD)){//predpoklad 5 a 6
                System.out.println("Pri vstupoch, ktoré boli zadané, bola porušená podmienka nadmerného " +
                        "vychýlenia z trhovej rovnováhy. Zadajte hodnoty odznova.");
                return false;
            }
            System.out.println("Podmienka 4 bola splnená. Vykonávam akciu pre podmienku 4.");
            return true;
        } else {
            // Žiadna podmienka nebola splnená
            System.out.println("Nie je možné vykonať žiadnu ďaľšiu akciu(žiadna z podmienok nebola splnená).");
            return false;

        }
    }
}
