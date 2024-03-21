package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //vstupne premene
       /* double aH_initial = 20.0;
        double bH_initial = 50.0;
        double aH = 24;
        double aD = 16;
        double bH = 40;
        double bD = 55;
        double rf = 0.05;
        double m = 7000;
        double z = 0 ;*/
        // Uvítacie privítanie
        System.out.println("Vitajte v programe na vyhodnotenie podmienok investícií do akcii a dlhopisov.");
        System.out.println("Po stlačení Enter začnite zadávať hodnoty.");
        Scanner scanner = new Scanner(System.in);
        // Čakanie na stlačenie Enter
        scanner.nextLine();


        double aH_initial = validaciaVstupov(scanner, "Zadajte počiatočnú hodnotu akcie A pred udalosťami:");
        double bH_initial = validaciaVstupov(scanner, "Zadajte počiatočnú hodnotu akcie B pred udalosťami:");
        double aH = validaciaVstupov(scanner, "Zadajte hodnotu premennej aH:");
        double aD = validaciaVstupov(scanner, "Zadajte hodnotu premennej aD:");
        double bH = validaciaVstupov(scanner, "Zadajte hodnotu premennej bH:");
        double bD = validaciaVstupov(scanner, "Zadajte hodnotu premennej bD:");
        double rf = validaciaVstupov(scanner, "Zadajte hodnotu premennej rf:");
        double m = validaciaVstupov(scanner, "Zadajte hodnotu premennej m:");
        double y0 = validaciaVstupov(scanner, "Zadajte hodnotu premennej y0:");
        double x0 = validaciaVstupov(scanner, "Zadajte hodnotu premennej x0:");
        double z0 = validaciaVstupov(scanner, "Zadajte hodnotu premennej z0:");

        kontrolaPodmienok(aH, aD, bH, bD, rf);
        //premene s ktorymi pracuje program
        double x ,y,zX=1,zY=1 ,x2 , y2;

        // Výpočet hodnoty lavej strany  z rovnice eliminácie rizika
       // double vysledok = (aH  / aH_initial) * x + (bH   / bH_initial) * y + (1 + rf) * z - m;
        x= (aH  / aH_initial);
        y= (bH   / bH_initial);
        // Výpočet hodnoty pravej strany  z rovnice eliminácie rizika
        //double vysledok2 = (aD  / aH_initial) * x + (bD   / bH_initial) * y + (1 + rf) * z - m;
        x2 =(aD  / aH_initial);
        y2=(bD   / bH_initial);

        System.out.println("Výsledok: " + x2);
        System.out.println("Výsledok: " + y2);
        double xPom = ( (y2 - y) / (x - x2) + (y2 - y)); // pomocna premena pri overovani ci je k nerovna -1
        if(xPom  == -1){
            System.out.println("Ak sa k = -1 znamená to , že x + y = 0 ,z = m . X a Y nevieme z rovníc vyjadriť. " +
                    "Preto z ide do + "+'\u221E');
        }

            //zvysne vypocty
        x=x-x2;
        y2 = y2-y;
        x= y2/x;//vzsledok x
            //vypocet y
        System.out.println("Výsledok: " + x);
        y = 1;
        y=x+y;

            // Preklopenie zlomku a prehodenie na pravu stranu
        y=1/y;

        zY= -zY * y;

            //zbytok vypoctov pre y
        y=y*m;

        y=Math.round(y);
            //pre x

        x=m-y;
        zX=-zX-zY;

            //zisk
        x=(aH  / aH_initial)*x;
        zX=(aH  / aH_initial) *zX;
        y=(bH   / bH_initial)*y;
        zY=(bH   / bH_initial)  *zY;

        double v,v1;
        v=x+y;
        v1=1+zX+zY ;




        System.out.println("Výsledok: " + v);
        System.out.println("Výsledok: " + v1);
        // opatavone preratanie pre vypocet J
        x= (aH  / aH_initial);
        y= (bH   / bH_initial);
        x2 =(aD  / aH_initial);
        y2=(bD   / bH_initial);
        double j = ((x * y2 - x2 * y - (x - x2) - (y2 - y)) / (x - x2 + y2 - y)); //vypocet j
       // j= j * -1;
        if(rf > j && j > 0 || j < 0 && 0 < rf){

            if(rf > j && j > 0){
                System.out.println("Vysledok J je sice vacsi ako  0 ale nieje vacsi ako urokova miera\n" +
                        "dlhopisu preto maximalizujeme z = m. Popripade ked vlastnime nejake akcie A,B v case 0 ,\n " +
                        "mozeme ich predat a naspat nakupit v case 1. zisk bude stale vacsi tym ze z -> "+'\u221E');
            }
            if(j < 0 && 0 < rf){
                System.out.println("tak hodnoty x, y by pri investovaní do akcií bolo za účelom\n" +
                        "eliminácie rizika potrebné voliť tak, aby x + y < 0 p.j");
            }
        }
        if(j == 0){
            System.out.println("V špeciálnom prípade, v ktorom J = 0, nákup/predaj akcií v zodpovedajú-\n" +
                    "com riziko eliminujúcom pomere neprináša žiadne dodatočné finančné odmeny a\n" +
                    "3\n" +
                    "preto sa investori snažia všetky dostupné finančné prostriedky investovať do ná-\n" +
                    "kupu dlhopisov.");
        }
            Zopt.vypocetZOpt(xPom,x0,y0,m,z0,rf,aH,bH);


    }
    private static double validaciaVstupov(Scanner scanner, String message) {
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
    private static void kontrolaPodmienok(double aH, double aD, double bH, double bD, double rf) {
        // Kontrola podmienok
        if ((aH > 1 + rf && 1 + rf > 1 && 1 > aD && bH < 1 && 1 < 1 + rf && 1 + rf < bD) &&
                (aH != aD && bH != bD)) {
            // Akcia pre podmienku 1
            System.out.println("Podmienka 1 bola splnená. Vykonávam akciu pre podmienku 1.");
        } else if ((aH < 1 && 1 < 1 + rf && 1 + rf < aD && bH > 1 + rf && 1 + rf > 1 && 1 > bD) &&
                (aH != aD && bH != bD)) {
            // Akcia pre podmienku 2
            System.out.println("Podmienka 2 bola splnená. Vykonávam akciu pre podmienku 2.");
        } else if ((aH > 1 + rf && 1 + rf > 1 && 1 > aD && bH > 1 + rf && 1 + rf > 1 && 1 > bD) &&
                (aH != aD && bH != bD)) {
            // Akcia pre podmienku 3
            System.out.println("Podmienka 3 bola splnená. Vykonávam akciu pre podmienku 3.");
        } else if ((aH < 1 && 1 < 1 + rf && 1 + rf < aD && bH < 1 && 1 < 1 + rf && 1 + rf < bD) &&
                (aH != aD && bH != bD)) {
            // Akcia pre podmienku 4
            System.out.println("Podmienka 4 bola splnená. Vykonávam akciu pre podmienku 4.");
        } else {
            // Žiadna podmienka nebola splnená
            System.out.println("Nie je možné vykonať žiadnu akciu.");
        }
    }
}