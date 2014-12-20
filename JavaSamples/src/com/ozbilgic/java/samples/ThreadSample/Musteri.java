package com.ozbilgic.java.samples.ThreadSample;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 18.12.2014
 */
public class Musteri implements Hesap {
    private static double tPara;
    private String musteriAdi;
    private static int islemSayisi;

    public Musteri(double miktar, String musteriAdi) {
        tPara += miktar;
        this.musteriAdi = musteriAdi;
    }

    @Override
    public void paraCek(double miktar) {
        synchronized (this) {
            if (miktar > tPara) {
                System.out.println("-----------------------------------------------------\n"
                        + "Bu miktar çekilemiyor (" + miktar + " TL). Çekilebilecek para miktarı: " + tPara + " TL\n"
                        + "İşlemi yapan: " + musteriAdi + "\n");
                islemSayisi++;
            } else {
                tPara -= miktar;
                System.out.println("-----------------------------------------------------\n"
                    +"Para çekildi ("+miktar+" TL). Kalan: "+tPara+" TL\n"
                    +"Parayı çeken: "+musteriAdi+"\n");
                islemSayisi++;
            }
        }
    }

    @Override
    public void paraYatir(double miktar) {
        synchronized (this) {
            tPara += miktar;
            System.out.println("-----------------------------------------------------\n"
                +"Para yatırıldı. ("+miktar+" TL)\n"
                +"Para yatıran: "+musteriAdi+"\n"
                +"Toplam para: "+tPara+" TL\n");
            islemSayisi++;
        }
    }

    public void kasadakiParayiGoster() {
        synchronized (this) {
            System.out.println("-----------------------------------------------------\n"
                +"Kasadaki para: "+tPara+" TL\n");
        }
    }

    public static void islemSayisiGoster() {
        System.out.println("Toplam işlem: "+islemSayisi);
    }
}
