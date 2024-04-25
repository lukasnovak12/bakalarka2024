package org.example;

public class Zopt {

    public static double vypocetZOpt(double k, double x0, double y0, double m,double z0, double rf,double aH, double bH) {
        double zOpt = 0.0;

        if (k != -1 && rf > 0) {
            if (k > 0) {
                zOpt = z0;
                //  pre k > 0
                if (x0 > (k / (1 + k)) * (m - z0)) {
                    zOpt = m - (1 + k) * x0 / k;
                }
            } else if (k < -1) {
                if (y0 <= (1 / (1 + k)) * (m - z0)) {
                    zOpt = z0;
                } else {
                    zOpt = m - (1 + k) * y0;
                }
            } else { // -1 < k < 0
                if (x0 <= (k / (1 + k)) * (m - z0)) {
                    zOpt = z0;
                } else {
                    zOpt = m - (1 + k) * x0 / k;
                }
            }
        } else { // k = -1 alebo rf <= 0
            if (aH == bH) {
                zOpt = m;
            } else if (aH > bH) {
                zOpt = m;
            } else { // aH < bH
                zOpt = m;
            }
        }

        return zOpt;
    }

    
}
