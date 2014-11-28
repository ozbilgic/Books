package com.ozbilgic.java.samples.Console;

import java.util.Scanner;

/**
 * @author Vision2
 * @since 27.11.2014
 * @version 0.0.2
 */
public class ConsoleDataEntered {
    /**
     * main(String[] args) metodu olusturuldugu sinifa kendi basina calisabilen bir ozellik katar.
     * Bu metoda disaridan veri atanabilir.
     * Eg. Console: java com.ozbilgic.java.samples.Console.ConsoleDataEntered deger deger2 ...
     * @param args: disaridan veriyi alan nesne (gelen verinin turu farketmez).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("- Enter your data:");

        do {
            s = scanner.next();
            System.out.println("Entered value: " + s);
        } while (!s.equals("exit"));

        /**
         * main(String[] args) metodunun dışarıdan aldığı verilerin konsola yazdırılması...
         */
        System.out.println("Argumanlar:");
        for (String ss:args) {
            System.out.println(ss);
        }
    }
}
