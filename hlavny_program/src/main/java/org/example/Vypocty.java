package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Vypocty {
    public Vypocty() {
        Vstupy vstupy = new Vstupy();
        //vstupne premene
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
        double x ,y,zX=1,zY=1 ,x2 , y2;
        // Výpočet hodnoty lavej strany  z rovnice eliminácie rizika
        // double vysledok = (aH  / aH_initial) * x + (bH   / bH_initial) * y + (1 + rf) * z - m;
        // vypocet ako pri pocitani ked je ah 55 a ah initial 50 tak vysledok je 1,1. je to koli
        //vypoctu kedze zlomok tu nezapisem
        x= (aH  / aPociatok);
        y= (bH   / bPociatok);
        // Výpočet hodnoty pravej strany  z rovnice eliminácie rizika
        //double vysledok2 = (aD  / aH_initial) * x + (bD   / bH_initial) * y + (1 + rf) * z - m;
        x2 =(aD  / aPociatok);
        y2=(bD   / bPociatok);

        if (!KontrolaP.kontrolaPodmienok(x, x2, y, y2, rf)){
            return;
        }

        double k = ( (bD - bH) / (aH - aD)); // vypocet k
        System.out.println("K = "+k);

        //zvysne vypocty podla vzorca x = ( bD − bH / aH − aD )y

        x=x-x2;
        y2 = y2-y;
        x= y2/x;//vysledok x = ( bD − bH / aH − aD )y
        //vypocet y kedze x uz pozname
        //y=1 pre otocenie zlomku a vyuzitie premennej
        y = 1;
        y=x+y;
        // Preklopenie zlomku a prehodenie na pravu stranu
        y=1/y;
        zY= -zY * y;
        //zbytok vypoctov pre y
        y=y*m;
        //zaokruhlenie pre y*m (vysledok 4/7 * 7000 bolo 3999,99) preto to zaokruhlenie na cele cislo (priklad)
        y=Math.round(y);
        //pre x
        x=m-y;
        zX=-zX-zY;
        Vysledky vysledky = Zisk.VypocetZisk(x,zX,y,zY,aH,bH,aPociatok,bPociatok,m);
        System.out.println("Výsledok zisku z lavej strany rovnice(udalosť H): " + vysledky.getVysledok1());
        System.out.println("Výsledok Z zo zisku z lavej strany rovnice(udalosť H): " + vysledky.getVysledok2());
        vysledky = Zisk.VypocetZisk(x,zX,y,zY,aD,bD,aPociatok,bPociatok,m);
        System.out.println("Výsledok zisku z pravej strany rovnice(udalosť D): " + vysledky.getVysledok1());
        System.out.println("Výsledok Z zo zisku z pravej strany rovnice(udalosť D): " + vysledky.getVysledok2());
        // opatavone preratanie pre vypocet J (nebolo by treba prepocitavat pokial dosadime do vzorca vyjde rovnako,
        //ale pre vypocet v mensich hodnotach na papieri je to jednoduchsie) priklad: 55/50 = 1,1x atd.
        x= (aH  / aPociatok);
        y= (bH   / bPociatok);
        x2 =(aD  / aPociatok);
        y2=(bD   / bPociatok);
        double j = ((x * y2 - x2 * y - (x - x2) - (y2 - y)) / (x - x2 + y2 - y)); //vypocet j
        System.out.println("J = "+j);

        if(rf > j && j > 0 || j < 0 && 0 < rf){

            if(j > 0){
                System.out.println("Výsledok J je síce väčší ako 0 ale nieje väčší ako úroková miera\n" +
                        "dlhopisu preto maximalizujeme z = m. Poprípade keď vlastníme nejaké akcie A,B v čase 0 ,\n " +
                        "môžeme ich predať a naspäť nakúpiť v čase 1. Zisk bude stále väčší tým, že z -> "+'∞');
            }
            if(j < 0){
                System.out.println("Hodnoty x, y by pri investovaní do akcií bolo za účelom\n" +
                        "eliminácie rizika potrebné voliť tak, aby x + y < 0 p.j");
            }
        }
        if (j > rf && rf > 0){
            System.out.println("Investícia x p.j. do akcií A a y p.j. do akcií B by musela byť\n" +
                    "uskutočnená tak, aby x + y > 0 p.j. Tento prípad však umožňuje investorovi potenciálne\n" +
                    "neobmedzený nárast zisku voľbou z → −∞ na elimináciu rizika. Výška zisku závisí od toho,\n" +
                    "koľko je investor schopný vypísať a predať v čase 0 dlhopisov na získanie finančných\n" +
                    "prostriedkov potrebných na nákup akcií v zodpovedajúcom riziko eliminačnom pomere.\n" +
                    "Platí 0 < x + y = m − z p.j");
        }
        if(j == 0){
            System.out.println("V špeciálnom prípade, v ktorom J = 0, nákup/predaj akcií v zodpovedajú-\n" +
                    "com riziko eliminujúcom pomere neprináša žiadne dodatočné finančné odmeny a\n" +
                    "preto sa investori snažia všetky dostupné finančné prostriedky investovať do ná-\n" +
                    "kupu dlhopisov.");
        }
        //pokial si uzivatel vybral generovanie cisel pre x0,y0,z0 tak sa tento kod uskutocni, v kode je generovanie cisel
        //nasledna kontrola ci je cislo cele a ukladanie a mazanie terminalu pre rovnake vypisi. aby nebolo treba robit novu metodu pre
        //zOpt bez vypisov premaze vzdy len vystup z metody
        double  zOpt;
        String vstup = vstupy.getInput();
        if (vstup.equals("y")) {
            do {
                PrintStream povodnyVystup = System.out;
                ByteArrayOutputStream ulozenieVystupu = new ByteArrayOutputStream();
                PrintStream novyVystup = new PrintStream(ulozenieVystupu);
                System.setOut(novyVystup);
                System.out.print("\033[H\033[2J");
                System.out.flush();
                x0 = generovanieNahodnychCisel();
                y0 = generovanieNahodnychCisel();
                z0 = generovanieNahodnychCisel();
                zOpt = Zopt.vypocetZOpt(k, j, x0, y0, m, z0, rf, aH, bH);
                System.out.flush();
                System.setOut(povodnyVystup);
            } while (!jeCeleCislo(zOpt));
            System.out.println("Vygenerované číslo x0: " + x0);
            System.out.println("Vygenerované číslo y0: " + y0);
            System.out.println("Vygenerované číslo z0: " + z0);
        }
        Zopt.vypocetZOpt(k,j,x0,y0,m,z0,rf,aH,bH);
    }
    public static boolean jeCeleCislo(double number) {
        return number == (int) number;
    }

    public static int generovanieNahodnychCisel() {
        Random random = new Random();
        return random.nextInt(501) * -1;
    }
}
