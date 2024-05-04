package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //vstupne premene
        double aPociatok = 0;
        double bPociatok = 0;
        double aH = 0;
        double aD = 0;
        double bH = 0;
        double bD = 0;
        double rf = 0;
        double m = 0;
        double z = 0 ;
        double x0 = 0;
        double y0 = 0;
        double z0 = 0;
        // Uvítacie privítanie
        System.out.println("Vitajte v programe na vyhodnotenie podmienok investícií do akcii a dlhopisov.");
        System.out.println("Po stlačení Enter začnite zadávať hodnoty.");
        Scanner scanner = new Scanner(System.in);
        // Čakanie na stlačenie Enter
        scanner.nextLine();


        aPociatok = validaciaVstupov(scanner, "Zadajte počiatočnú hodnotu akcie A pred udalosťami:");
        bPociatok = validaciaVstupov(scanner, "Zadajte počiatočnú hodnotu akcie B pred udalosťami:");
        aH = validaciaVstupov(scanner, "Zadajte hodnotu premennej aH:");
        aD = validaciaVstupov(scanner, "Zadajte hodnotu premennej aD:");
        bH = validaciaVstupov(scanner, "Zadajte hodnotu premennej bH:");
        bD = validaciaVstupov(scanner, "Zadajte hodnotu premennej bD:");
        rf = validaciaVstupov(scanner, "Zadajte hodnotu premennej rf:");
        m = validaciaVstupov(scanner, "Zadajte hodnotu premennej m:");
        y0 = validaciaVstupov(scanner, "Zadajte hodnotu premennej y0:");
        x0 = validaciaVstupov(scanner, "Zadajte hodnotu premennej x0:");
        z0 = validaciaVstupov(scanner, "Zadajte hodnotu premennej z0:");


        kontrolaPodmienok(aH, aD, bH, bD, rf);

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

        if (!kontrolaPodmienok(x, x2, y, y2, rf)){
            System.out.println("Zadané premenné nevyhovujú ani jednej z prvých štyroch podmienok, tým pádom nie je možné\n" +
                    "príklad dopočítať.");
            return;
        }

        double k = ( (bD - bH) / (aH - aD)); // vypocet k
        System.out.println("K = "+k);

            //zvysne vypocty podla vzorca x = ( bD − bH / aH − aD )y

        x=x-x2;
        y2 = y2-y;
        x= y2/x;//vysledok x = ( bD − bH / aH − aD )y
        System.out.println("Výsledok: " + x);

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
            //zisk
        x=(aH  / aPociatok)*x;
        zX=(aH  / aPociatok) *zX;
        y=(bH   / bPociatok)*y;
        zY=(bH   / bPociatok)  *zY;

        double v,v1;
        v=x+y;
        v1=1+zX+zY ;


        System.out.println("Výsledok: " + v);
        System.out.println("Výsledok: " + v1);
        // opatavone preratanie pre vypocet J (nebolo by treba prepocitavat pokial dosadime do vzorca vyjde rovnako,
        //ale pre vypocet v mensich hodnotach na papieri je to jednoduchsie) priklad: 55/50 = 1,1x atd.
        x= (aH  / aPociatok);
        y= (bH   / bPociatok);
        x2 =(aD  / aPociatok);
        y2=(bD   / bPociatok);
        double j = ((x * y2 - x2 * y - (x - x2) - (y2 - y)) / (x - x2 + y2 - y)); //vypocet j
        System.out.println("J = "+j);

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
                    "3\n" +
                    "preto sa investori snažia všetky dostupné finančné prostriedky investovať do ná-\n" +
                    "kupu dlhopisov.");
        }
            Zopt.vypocetZOpt(k,j,x0,y0,m,z0,rf,aH,bH);


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

    private static boolean kontrolaPodmienok(double aH, double aD, double bH, double bD, double rf) {
        // Kontrola podmienok
        if ((aH > 1 + rf && 1 + rf > 1 && 1 > aD && bH < 1 && 1 < 1 + rf && 1 + rf < bD) &&
                (aH != aD && bH != bD)) {
            // Akcia pre podmienku 1
            System.out.println("Podmienka 1 bola splnená. Vykonávam akciu pre podmienku 1.");
            return true;
        } else if ((aH < 1 && 1 < 1 + rf && 1 + rf < aD && bH > 1 + rf && 1 + rf > 1 && 1 > bD) &&
                (aH != aD && bH != bD)) {
            // Akcia pre podmienku 2
            System.out.println("Podmienka 2 bola splnená. Vykonávam akciu pre podmienku 2.");
            return true;
        } else if ((aH > 1 + rf && 1 + rf > 1 && 1 > aD && bH > 1 + rf && 1 + rf > 1 && 1 > bD) &&
                (aH != aD && bH != bD)) {
            // Akcia pre podmienku 3
            System.out.println("Podmienka 3 bola splnená. Vykonávam akciu pre podmienku 3.");
            return true;
        } else if ((aH < 1 && 1 < 1 + rf && 1 + rf < aD && bH < 1 && 1 < 1 + rf && 1 + rf < bD) &&
                (aH != aD && bH != bD)) {
            // Akcia pre podmienku 4
            System.out.println("Podmienka 4 bola splnená. Vykonávam akciu pre podmienku 4.");
            return true;
        } else {
            // Žiadna podmienka nebola splnená
            System.out.println("Nie je možné vykonať žiadnu akciu(ziadna z podmienok nebola splnena).");
            return false;

        }
    }
}