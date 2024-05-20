package org.example;

public class KontrolaP {
    public static boolean kontrolaPodmienok(double aH, double aD, double bH, double bD, double rf) {
        // Kontrola podmienok
        if ((aH > 1 + rf && 1 + rf > 1 && 1 > aD) && (bH < 1 && 1 < 1 + rf && 1 + rf < bD)) {
            // Akcia pre podmienku 1
            System.out.println("Podmienka 1 bola splnená. Vykonávam akciu pre podmienku 1.");
            return true;
        } else if ((aH < 1 && 1 < 1 + rf && 1 + rf < aD) && (bH > 1 + rf && 1 + rf > 1 && 1 > bD)) {
            // Akcia pre podmienku 2
            System.out.println("Podmienka 2 bola splnená. Vykonávam akciu pre podmienku 2.");
            return true;
        } else if ((aH > 1 + rf && 1 + rf > 1 && 1 > aD) && (bH > 1 + rf && 1 + rf > 1 && 1 > bD)) {
            // Akcia pre podmienku 3
            System.out.println("Podmienka 3 bola splnená. Vykonávam akciu pre podmienku 3.");
            return true;
        } else if ((aH < 1 && 1 < 1 + rf && 1 + rf < aD) && (bH < 1 && 1 < 1 + rf && 1 + rf < bD)) {
            // Akcia pre podmienku 4
            System.out.println("Podmienka 4 bola splnená. Vykonávam akciu pre podmienku 4.");
            return true;
        } else {
            // Žiadna podmienka nebola splnená
            System.out.println("Nie je možné vykonať žiadnu ďaľšiu akciu(ziadna z podmienok nebola splnena).");
            return false;

        }
    }
}
