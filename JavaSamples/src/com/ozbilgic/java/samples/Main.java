/**
 * Bu sinifta test amacli kodlar kullanilicaktir.
 */
package com.ozbilgic.java.samples;

import java.util.Arrays;
import java.util.Scanner;

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

        dongu();

        switch ((int)d) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                System.out.print("10");
                System.out.print(" ile ");
                System.out.print("15 arasında");
                break;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                System.out.println("16 ile 20 arasında");
                break;
            default:
                System.out.println("bilinmiyor");
        }
        System.out.println();
        for (int i=0; i<200; i++)
            System.out.print((i + 1) + "-");
        System.out.println();
        for (int i=200; i > 0; i--) {
            System.out.print((i) + "-");
        }
        System.out.println();
        for (int i=0; i<100; i++)
            if ((i+1) % 10 == 0) System.out.print((i+1)+"-");
        System.out.println();

        class deneme {
            int i;
            public deneme() {
                i = 1;
            }

            public deneme(int i) {
                this.i = i;
            }

            public int deneme() {
                return 0;
            }

            deneme classReferance() {
                return this;
            }

            void mesaj(String msg) {
                System.out.println(msg);
            }
        }

        deneme deneme = new deneme();
        System.out.println(deneme.deneme());

        deneme.classReferance().classReferance().classReferance().mesaj("referance");

        Scanner scanner = new Scanner(System.in);
        String ss;
        System.out.println("- Enter your data:");
        Test test1 = new Test("test1");
        Test test2 = new Test("test2");
        Test test3 = new Test("test3");
        Test test4 = new Test("test4");
        Test test5 = new Test("test5");

        String[] str = new String[10];
        str[0] = "a";
        str[1] = "b";
        str[2] = "c";
        str[3] = "d";
        str[4] = "e";
        str[5] = "f";
        int t = Arrays.binarySearch(str, "c");
        if (t > -1) System.out.println(str[t]);

        int sayac = 5;
        int dongu;
        do {
            ++sayac;
            new Test("test"+sayac);
            ss = scanner.next();
            dongu = sayiMi(ss);

            for (int i=0; i<dongu; i++) {
                ++sayac;
                new Test("test"+sayac);
            }

            if (ss.equals("gc")) System.gc();
            System.out.println("Entered value: " + ss);
            System.out.println("Toplam nesne: "+Test.j);
        } while (!ss.equals("exit"));
        System.out.println("Toplam nesne: "+Test.j);

        int[][][][][][] dizi = new int[2][3][2][2][1][2];//2*3*2*2*1*2 = 48 elemanlı matriks
        System.out.println("çok boyutlu dizi: "+dizi.length);
        dizi[1][2][1][1][0][1] = 1;//dizinin son elemanı.
    }

    public static void dongu() {
        for (int i=0; i<10; i++) {
            for (int j=0; j<50; j++) {
                return;
            }
            System.out.println(i);
        }
    }

    public static int sayiMi(String s) {
        int i = 0;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("sayı değil");
        }
        return i;
    }
}
