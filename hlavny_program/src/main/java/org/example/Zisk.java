package org.example;

public class Zisk {

    public static Vysledky VypocetZisk(double x , double zX, double y , double zY,double aHD, double bHD, double aPociatok, double bPociatok, double m){
        x=(aHD  / aPociatok)*x;
        zX=(aHD  / aPociatok) *zX;
        y=(bHD   / bPociatok)*y;
        zY=(bHD   / bPociatok)  *zY;
        double v,v1;
        v=zX+zY;
        v=m-v;
        v1=x+y;
        v1=(m-(v1*m))*(-1);
        v=Math.round(v);
        v1=Math.round(v1);


        return new Vysledky(v,v1);
        }
}
