package com.ozbilgic.java.samples;

import com.sun.corba.se.impl.io.TypeMismatchException;

import java.util.Scanner;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 17.12.2014
 */
public class IntToHex {
    public static void main(String[] args) {
        System.out.println(">> Rakamı gir:");
        Scanner scan = new Scanner(System.in);
        int userEnt =  scan.nextInt();

        try {
            while (userEnt != -1) {
                System.out.println("Hex: 0x" + Integer.toHexString(userEnt));
                System.out.println(">> Rakamı gir:");
                userEnt = scan.nextInt();
            }
        } catch (TypeMismatchException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
