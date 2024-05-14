package org.example;

public class HodnotaJ {

    public static double vypocetAVypisJ(double aPociatok, double bPociatok, double aH, double bH, double aD, double bD, double rf) {
        double x= (aH  / aPociatok);
        double y= (bH   / bPociatok);
        double x2 =(aD  / aPociatok);
        double y2=(bD   / bPociatok);
        double j = ((x * y2 - x2 * y - (x - x2) - (y2 - y)) / (x - x2 + y2 - y)); //vypocet j
        j = Math.round(j * 10000.0) / 10000.0;
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
        if(j == rf){
            System.out.println("Pokiaľ J = rf , tak investor nemôže žiadnym spôsobom navýšiť svoj zisk. Výber z\n" +
                    "môže byť ľubovoľný, pretože pre ktorúkoľvek jeho hodnotu bude zisk investora rovný\n" +
                    "práve Jm = rf m p.j. V takomto prípade arbitráž neexistuje a bezriziková úroková sadzba\n" +
                    "dlhopisu je správne (bezarbitrážne) určená.");

        }
        return j;
    }
}
