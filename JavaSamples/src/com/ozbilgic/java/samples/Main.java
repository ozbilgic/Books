/**
 * Bu sinifta test amacli kodlar kullanilicaktir.
 */
package com.ozbilgic.java.samples;

/**
 * @author ozbilgic
 * @since 19.11.2014
 * @version 0.0.2
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Integer i0 = 0; //sarmalayici sinif atamasi. "i0" nesnesine bircok ozellik kazandirir.
        int i1 = 0; //ilkel tip atamasi. Sadece veriyi okuma ve yazma icin.
        String s = "15.2";
        double d;
        d = Double.parseDouble(s);
        System.out.println(d);
        System.out.println(s.equals("15"));
    }
}
