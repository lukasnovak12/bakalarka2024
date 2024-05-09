package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //vstupne premene
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
        // Uvítacie privítanie
        System.out.println("Vitajte v programe na vyhodnotenie podmienok investícií do akcii a dlhopisov.");
        System.out.println("Po stlačení Enter začnite zadávať hodnoty.");
        Scanner scanner = new Scanner(System.in);
        // Čakanie na stlačenie Enter
        scanner.nextLine();


        aPociatok = Validacia.validaciaVstupov(scanner, "Zadajte počiatočnú hodnotu akcie A pred udalosťami:");
        bPociatok = Validacia.validaciaVstupov(scanner, "Zadajte počiatočnú hodnotu akcie B pred udalosťami:");
        aH = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej aH:");
        aD = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej aD:");
        bH = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej bH:");
        bD = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej bD:");
        rf = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej rf:");
        m = Validacia.validaciaVstupov(scanner, "Zadajte hodnotu premennej m:");
        System.out.println("Zadajte hodnotu premennej y0:");
        y0 = scanner.nextDouble();
        System.out.println("Zadajte hodnotu premennej x0:");
        x0 = scanner.nextDouble();
        System.out.println("Zadajte hodnotu premennej z0:");
        z0 = scanner.nextDouble();





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

        KontrolaP.kontrolaPodmienok(x, x2, y, y2, rf);

        if (!KontrolaP.kontrolaPodmienok(x, x2, y, y2, rf)){
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
        zX=(aD  / aPociatok) *zX;
        y=(bH   / bPociatok)*y;
        zY=(bD   / bPociatok)  *zY;
        //skusobne vypocty
        double v,v1;
        v=x+y;
        v=m-v;
        v1=1+zX+zY ;
        v1=v1*m;
        System.out.println("Výsledok zisku z lavej strany rovnice: " + v);
        System.out.println("Výsledok z zo zisku z ppravej strany rovnice: " + v1);
        //skusobne vypocty

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
        Zopt.vypocetZOpt(k,j,x0,y0,m,z0,rf,aH,bH);


    }

}