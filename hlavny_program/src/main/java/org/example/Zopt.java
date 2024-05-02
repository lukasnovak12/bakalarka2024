package org.example;

public class Zopt {

    public static double vypocetZOpt(double k,double j, double x0, double y0, double m,double z0, double rf,double aH, double bH) {
        double zOpt = 0.0;

        if (k != -1 && j<rf) {
            if (k > 0) {
                zOpt = Math.min(Math.min(m - x0 - y0, m - (1 + k) * x0 / k), m - (1 + k) * y0);
                System.out.println("Ak x0 = ky0, tak zopt = m − x0 − y0, xopt = x0, yopt = y0.\n" +
                        " Ak x0 > ky0, tak zopt = m − (( 1+k)x0/k), xopt = x0, yopt = x0/k > y0.\n" +
                        " Ak x0 < ky0, tak zopt = m − (1 + k) y0, xopt = ky0 > x0, yopt = y0.");
            } else if (k < -1) {
                zOpt=m-(1+k)*x0/k;
                System.out.println("Investor dokaze navisit svoj arbitrazny zisk prostrednictvom penaznych" +
                        "prostriedkov yiskanych z predaja akcie A v case 0 . V pripade ze nieje schopny vyuzit vzniknutu" +
                        "arbitraznu prilezitost, pretoze nevlastni ziadne akcie A v case  0 ,ktore mohol predat, jeho yisk bude rovny rfm.");

            } else { // -1 < k < 0
            zOpt=m-(1+k)*y0;
                System.out.println("Investor dokaze navisit svoj arbitrazny zisk prostrednictvom penaznych" +
                        "prostriedkov yiskanych z predaja akcie B v case 0 . V pripade ze nieje schopny vyuzit vzniknutu" +
                        "arbitraznu prilezitost, pretoze nevlastni ziadne akcie B ,ktore mohol predat, jeho yisk bude rovny rfm.");
            }
        } else if(k != -1 && j>rf){
            if (k > 0) {
                zOpt = z0;
                System.out.println("Ak k>0 pri k != -1 && j>rf, potom potom maximom je z0< 0, a pre investora je podstatne to, ci dokaye" +
                        "svoj arbitrazny zisk navysit predajom vypisanych dlhopisov v case 0 . ");
            } else if (k < -1) {
                if (y0 <= (1 / (1 + k)) * (m - z0)) {
                    zOpt = z0;
                    System.out.println("Predpokladajme , ze y0 ≤ ( 1/1+k)*(m − z0). Potom maximom je z0 a preto zopt = z0");
                } else {
                    zOpt = m - (1 + k) * y0;
                    System.out.println("Pokial neplati , ze y0 ≤ ( 1/1+k)*(m − z0) ,tak maximom  je v tomto prípade m − (1 + k)y0.");
                    }
                } else{ // -1 < k < 0
                    if (x0 <= (k / (1 + k)) * (m - z0)) {
                        zOpt = z0;
                        System.out.println(". Ak platí x0 ≤ ( k/1+k)*(m − z0) tak potom maximom je z0 a preto volime zopt=z0");
                    } else {
                        zOpt = m - (1 + k) * x0 / k;
                        System.out.println("dostávame zopt = m − ( 1+k/k )*x0");
                    }
                }
            }
        else{ // k = -1 alebo rf <= 0
            if (aH == bH) {
                zOpt = m;
                System.out.println("pokial k = -1 a aH = bH ,arbitraz na trhu neexistuje ahodnoty x, y môžu byť zvolené ľubovoľne tak, aby bolo splnené\n" +
                        "x = −y. z=m");
            } else if (aH > bH) {
                zOpt = m;
                System.out.println("pokial k = -1 a aH > bH  , tak je potrebné investovať do akcie A, t.j. voliť xopt > 0.");
            } else { // aH < bH
                zOpt = m;
                System.out.println("pokial k = -1 a aH < bH  ,tak potom je potrebné investovať do akcie B, t.j. voliť yopt > 0. ");
            }
        }

        return zOpt;
    }

    
}
