package org.example;

public class Zisk {

    public static Vysledky VypocetZisk(double x , double zX, double y , double zY,double aHD, double bHD, double aPociatok, double bPociatok, double m){
        x=(aHD  / aPociatok)*x;
        zX=(aHD  / aPociatok) *zX;
        y=(bHD   / bPociatok)*y;
        zY=(bHD   / bPociatok)  *zY;
        double v,v1;
        v=x+y;
        v=v-m;
        v1=1+zX+zY ;
        v1=v1*m;
        v=Math.round(v);
        v1=Math.round(v1);
        //10 20 12 8 24 10 0.02 5000
        //20 50 24 16 40 55 0,04 7000
        //20 30 18 24 33 24 0,01 6000
        //20 30 28 16 33 21 0.05 5000 opytat sa
        //10 10 14 8 7 13 0.03 2000 z0=-500

        return new Vysledky(v,v1);
        }
}
