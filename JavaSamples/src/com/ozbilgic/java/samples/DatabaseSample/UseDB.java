package com.ozbilgic.java.samples.DatabaseSample;

import java.util.Scanner;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 20.12.2014
 */
public class UseDB {
    public static void main(String[] args) {
        ConnectDatabase db = new ConnectDatabase("...dbpath...");
        db.connect();
        db.getAllData();

        Scanner scan = new Scanner(System.in);
        String isim, tel;

        isim = scan.next();
        tel = scan.next();

        db.setData(isim, tel);
        db.getAllData();
    }
}
