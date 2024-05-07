package org.example;

public class Zopt {

    public static double vypocetZOpt(double k,double j, double x0, double y0, double m,double z0, double rf,double aH, double bH) {
        double zOpt = 0.0;
        double xOpt = 0.0;
        double yOpt = 0.0;
        if (k != -1 && j<rf) {
            if (k > 0) {
                double pom = Math.min(m - x0 - y0, m - ((1 + k)/k) * x0 );
                zOpt = Math.min(pom, m - (1 + k) * y0);
                if (x0 == k* y0){
                    zOpt =m-x0-y0;
                    xOpt = x0;
                    yOpt = y0;
                    System.out.println("Ak x0 = ky0, tak zopt = m − x0 − y0, xopt = x0, yopt = y0.");
                } else if (x0 > k *y0) {
                    zOpt = m - ((1+k) * x0 / k);
                    xOpt = x0;
                    yOpt = x0/k;
                    System.out.println("Ak x0 > ky0, tak zopt = m − (( 1+k)x0/k), xopt = x0, yopt = x0/k > y0.");
                }else if (x0<k * y0) {
                    zOpt = m - (1 + k) * y0;
                    xOpt = k * y0;
                    yOpt = y0;
                    System.out.println("Ak x0 < ky0, tak zopt = m − (1 + k) y0, xopt = ky0 > x0, yopt = y0.");
                }
                System.out.println("zOpt = "+zOpt);
            } else if (k < -1) {
                zOpt=m-(1+k)*x0/k;
                System.out.println("Investor dokáže navíšit svoj arbitrážny zisk prostredníctvom penažných" +
                        "prostriedkov získanych z predaja akcie A v čase 0 . V prípade, že nieje schopný využiť vzniknutú" +
                        "arbitrážnu príležitost, pretože nevlastní žiadne akcie A v čase  0 ,ktoré mohol predať, jeho zisk bude rovný rfm.");
                System.out.println("zOpt = "+zOpt);
            } else { // -1 < k < 0
            zOpt=m-(1+k)*y0;
                System.out.println("Investor dokáže navíšit svoj arbitrážny zisk prostredníctvom penažných" +
                        "prostriedkov získanych z predaja akcie B v čase 0 . V prípade, že nieje schopný využiť vzniknutú" +
                        "arbitrážnu príležitost, pretože nevlastní žiadne akcie B v čase  0, ktoré mohol predať, jeho zisk bude rovný rfm");
                System.out.println("zOpt = "+zOpt);
            }
        } else if(k != -1 && j>rf){
            if (k > 0) {
                zOpt = z0;
                System.out.println("Ak k>0 pri k != -1 && j>rf, potom maximom je z0 < 0, a pre investora je podstatné to, či dokáže" +
                        "svoj arbitrážny zisk navýšiť predajom vypísaných dlhopisov v čase 0 . ");
                System.out.println("zOpt = "+zOpt);
            } else if (k < -1) {
                if (y0 <= (1 / (1 + k)) * (m - z0)) {
                    zOpt = z0;
                    System.out.println("Predpokladajme , že y0 ≤ ( 1/1+k)*(m − z0). Potom maximom je z0 a preto zopt = z0");
                    System.out.println("zOpt = "+zOpt);
                } else {
                    zOpt = m - (1 + k) * y0;
                    System.out.println("Pokiaľ neplatí , že y0 ≤ ( 1/1+k)*(m − z0) ,tak maximom  je v tomto prípade m − (1 + k)y0.");
                    System.out.println("zOpt = "+zOpt);
                    }
                } else{ // -1 < k < 0
                    if (x0 <= (k / (1 + k)) * (m - z0)) {
                        zOpt = z0;
                        System.out.println("Ak platí x0 ≤ ( k/1+k)*(m − z0) tak potom maximom je z0 a preto volíme zopt=z0");
                        System.out.println("zOpt = "+zOpt);
                    } else {
                        zOpt = m - (1 + k) * x0 / k;
                        System.out.println("Dostávame zopt = m − ( 1+k/k )*x0");
                        System.out.println("zOpt = "+zOpt);
                    }
                }
            }
        else{ // k = -1 alebo rf <= 0
            if (aH == bH) {
                zOpt = m;
                System.out.println("Pokiaľ k = -1 a aH = bH ,arbitráž na trhu neexistuje a hodnoty x, y môžu byť zvolené ľubovoľne tak, aby bolo splnené\n" +
                        "x = −y. z=m");
            } else if (aH > bH) {
                zOpt = m;
                System.out.println("Pokiaľ k = -1 a aH > bH  , tak je potrebné investovať do akcie A, t.j. voliť xopt > 0.");
            } else { // aH < bH
                zOpt = m;
                System.out.println("Pokiaľ k = -1 a aH < bH  ,tak potom je potrebné investovať do akcie B, t.j. voliť yopt > 0. ");
            }
        }

        return zOpt;
    }


}
