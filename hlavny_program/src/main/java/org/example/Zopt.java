package org.example;

public class Zopt {

    public static double vypocetZOpt(double k, double x0, double y0, double m,double z0, double rf,double aH, double bH) {
        double zOpt = 0.0;

        if (k != -1) {
            if (k > 0) {
                zOpt = Math.min(m - x0 - y0, m - (1 + k) * x0);
            } else if (k < -1) {
                zOpt = Math.max(y0, -m / k + (1 + k) * (y0 + z0));
            } else { // -1 < k < 0
                if (x0 <= (k / (1 + k)) * (m - z0)) {
                    zOpt = Math.max(z0, m - (1 + k) * x0);
                } else {
                    zOpt = Math.max(z0, -m / k + (1 + k) * (y0 + z0));
                }
            }
        } else { // k = -1
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
