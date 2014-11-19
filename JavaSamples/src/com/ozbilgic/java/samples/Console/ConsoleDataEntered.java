package com.ozbilgic.java.samples.Console;

import java.util.Scanner;

/**
 * Created Vision2 on 27.11.2014 - 17:33.
 */
public class ConsoleDataEntered {
    /**
     * Aşağıda konsoldan veri alabilen bir uygulama mevcuttur.
     * main metoduna dışarıdan veri atanabilir.
     * Ör. Consol: java com.ozbilgic.java.samples.Console.ConsoleDataEntered "deger" "deger2" ...
     * @param args: dışarıdan veriyi alan nesne.
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
         * main metodunun dışarıdan aldığı verilerin konsola yazdırılması...
         */
        System.out.println("Argumanlar:");
        for (String ss:args) {
            System.out.println(ss);
        }
    }
}
