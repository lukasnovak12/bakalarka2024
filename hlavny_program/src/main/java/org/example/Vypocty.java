package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Vypocty {

    public Vypocty() {
        // Uvítacie privítanie
        System.out.println("\nVitajte v programe na vyhodnotenie podmienok investícií do akcii a dlhopisov. \n" +
                "Program počíta optimálne hodnoty z hľadiska lineárneho programovania pre investovanie do akcií a dlhopisov.\n");
        System.out.println("Po stlačení Enter začnite zadávať hodnoty.");
        Scanner scanner = new Scanner(System.in);
        // Čakanie na stlačenie Enter
        scanner.nextLine();
        boolean repeat;
        do {
            Vstupy vstupy = new Vstupy();
            //volanie triedy vstupy z ktorej prijdu zadane hodnoty, ktore si tu program natiahne pomocou get
            double aPociatok = vstupy.getaPociatok();
            double bPociatok = vstupy.getbPociatok();
            double aH = vstupy.getaH();
            double aD = vstupy.getaD();
            double bH = vstupy.getbH();
            double bD = vstupy.getbD();
            double rf = vstupy.getRf();
            double m = vstupy.getM();
            double x0 = vstupy.getX0();
            double y0 = vstupy.getY0();
            double z0 = vstupy.getZ0();


            //premene s ktorymi pracuje program
            double x ,y,zX,zY,x2,y2;
            // Výpočet hodnoty lavej strany  z rovnice eliminácie rizika
            // double vysledok = (aH  / aH_initial) * x + (bH   / bH_initial) * y + (1 + rf) * z - m;
            // prenasobenie buducich hodnot tymi pociatocnymi.

            x= (aH  / aPociatok);
            y= (bH   / bPociatok);
            // Výpočet hodnoty pravej strany  z rovnice eliminácie rizika
            //double vysledok2 = (aD  / aH_initial) * x + (bD   / bH_initial) * y + (1 + rf) * z - m;
            x2 =(aD  / aPociatok);
            y2=(bD   / bPociatok);

            if (!KontrolaP.kontrolaPodmienok(x, x2, y, y2, rf)){//pokial kontrola podmnienok nepresla zavola metodu vypocty ako v main a program zadavanie zacina znova
                 new Vypocty();
            }

            double k = ( (y2 - y) / (x - x2)); // vypocet k
            k = Math.round(k * 1000.0) / 1000.0;
            System.out.println("K = "+k);
            //zvysne vypocty podla vzorca x = ( bD − bH / aH − aD )y  ==    x = ky
            if (k == -1){
                System.out.println("x = Nie je možné deliť nulou.");
                System.out.println("y = Nie je možné deliť nulou.");
            }else {
                x = (k / (1 + k));
                y = (1 / (1 + k));
                System.out.println("x = " + x);
                System.out.println("y = " + y);
            }

            // vypocet  J
            double j = HodnotaJ.vypocetAVypisJ(vstupy.getaPociatok(),vstupy.getbPociatok(),vstupy.getaH(),vstupy.getbH(),vstupy.getaD(),vstupy.getbD(),vstupy.getRf());
            if (j == rf || j==0){
                System.out.println(" ");
                new Vypocty();
            }else {

                //pokial si uzivatel vybral generovanie cisel pre x0,y0,z0 tak sa tento kod uskutocni, v kode je generovanie cisel
                //nasledna kontrola ci je cislo cele a ukladanie a mazanie terminalu pre rovnake vypisi. aby nebolo treba robit novu metodu pre
                //zOpt bez vypisov premaze vzdy len vystup z metody a starsi si ulozi
                // inspirovane z :: https://www.javatpoint.com/how-to-clear-screen-in-java
                Vysledky zOpt;
                String vstup = vstupy.getInput();
                if (vstup.equals("y")) {
                    do {
                        PrintStream povodnyVystup = System.out;
                        ByteArrayOutputStream ulozenieVystupu = new ByteArrayOutputStream();
                        PrintStream novyVystup = new PrintStream(ulozenieVystupu);
                        System.setOut(novyVystup);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        x0 = generovanieNahodnychCisel((int) m);
                        y0 = generovanieNahodnychCisel((int) m);
                        z0 = generovanieNahodnychCisel((int) m);
                        zOpt = Zopt.vypocetZOpt(k, j, x0, y0, m, z0, rf, vstupy.getaH() / vstupy.getaPociatok(), vstupy.getbH() / vstupy.getbPociatok());
                        System.out.flush();
                        System.setOut(povodnyVystup);
                    } while (!jeCeleCislo(zOpt.getVysledok3()) && !jeCeleCislo(zOpt.getVysledok2()) && !jeCeleCislo(zOpt.getVysledok1()));//vracia do cyklu naspat. pokial coslo zOpt nebolo cele cislo
                    System.out.println("Vygenerované číslo x0: " + x0);//vypis vygenerovanych cisel
                    System.out.println("Vygenerované číslo y0: " + y0);
                    System.out.println("Vygenerované číslo z0: " + z0);
                }
                zOpt = Zopt.vypocetZOpt(k, j, x0, y0, m, z0, rf, vstupy.getaH() / vstupy.getaPociatok(), vstupy.getbH() / vstupy.getbPociatok());

                zX = x * zOpt.getVysledok3();
                zY = y * zOpt.getVysledok3();
                Vysledky vysledky = Zisk.VypocetZisk(x, zX, y, zY, aH, bH, aPociatok, bPociatok, zOpt.getVysledok3());
                System.out.println("Výsledok lavej strany rovnice(udalosť H): " + vysledky.getVysledok1());
                System.out.println("Výsledok Z zo zisku z lavej strany rovnice(udalosť H): " + vysledky.getVysledok2());
                vysledky = Zisk.VypocetZisk(x, zX, y, zY, aD, bD, aPociatok, bPociatok, zOpt.getVysledok3());
                System.out.println("Výsledok zisku z pravej strany rovnice(udalosť D): " + vysledky.getVysledok1());
                System.out.println("Výsledok Z zo zisku z pravej strany rovnice(udalosť D): " + vysledky.getVysledok2());

            }
            System.out.print("Chcete zadať iný príklad? (´y´ pre áno / ´n´ pre nie): ");
            String response = scanner.next();
            repeat = response.equalsIgnoreCase("y");

        } while (repeat);
        }
    public static boolean jeCeleCislo(double number) {//kontroluje ci generator vygeneroval take cisla, kedy sa zopt rovna celemu cislu.
        return number == (int) number;
    }

    public static int generovanieNahodnychCisel(int m) {//generovanie cisel pre x0,y0 a z0 ktore su v rozsahu 0<= x0,y0,z0 <=m
        Random random = new Random();
        int cislo = random.nextInt(m/100 + 1);// generuje take cisla aby boli 100 nasobkom cisla 1. 0,100,200......m-100,m
        return (cislo *100)*(-1);
    }
}
