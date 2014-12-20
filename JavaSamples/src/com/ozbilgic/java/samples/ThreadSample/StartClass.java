package com.ozbilgic.java.samples.ThreadSample;

import java.util.Collection;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 18.12.2014
 */
public class StartClass {
    public static void main(String[] args) {
        ThreadGroup tGroup = new ThreadGroup("Yeni Grup");
        Odev1 is1 = new Odev1(tGroup, "iş 1");
        Odev1 is2 = new Odev1(tGroup, "iş 2");

        is1.start();
        is2.start();
        tGroup.list();

        Musteri musteri1 = new Musteri(200, "Levent Özbilgiç");
        Musteri musteri2 = new Musteri(50, "Bülent Özbilgiç");

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                musteri1.paraCek(10);
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 200; i++)
                musteri1.paraYatir(18);
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                musteri2.paraCek(30);
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 110; i++)
                musteri2.paraYatir(15);
        });

        thread1.start();
        thread2.start();
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.start();
        thread4.start();
        thread4.setPriority(Thread.MAX_PRIORITY);

        Thread thread5 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Musteri.islemSayisiGoster();
        });
        thread5.start();
    }
}
