package org.example;

public class Zisk {

    public static Vysledky VypocetZisk(double x , double zX, double y , double zY,double aHD, double bHD, double aPociatok, double bPociatok, double m){
        x=(aHD  / aPociatok)*x;
        zX=(aHD  / aPociatok) *zX;
        y=(bHD   / bPociatok)*y;
        zY=(bHD   / bPociatok)  *zY;
        System.out.println(x);
        System.out.println(zX);
        System.out.println(y);
        System.out.println(zY);
        //skusobne vypocty
        double v,v1;
        v=x+y;
        v=v-m;
        v1=1+zX+zY ;
        v1=v1*m;
        v1=Math.round(v1);

        return new Vysledky(v,v1);
        }
}
