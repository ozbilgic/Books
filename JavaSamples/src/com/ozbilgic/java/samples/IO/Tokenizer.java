package com.ozbilgic.java.samples.IO;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 17.12.2014
 */
public class Tokenizer {
    public static void main(String[] args) {
        StreamTokenizer st;

        try {
            st = new StreamTokenizer(new FileReader("C:\\JAVA\\java.pdf")); //dosya referansı
            double sayisalVerilerinToplami = 0;
            int kelimeSayisi = 0, karakterSayisi = 0;

            while (st.nextToken() != StreamTokenizer.TT_EOF) { //dosyanın sonuna gelene kadar devam et
                if (st.ttype == StreamTokenizer.TT_NUMBER) //okunan veri sayısal mı?
                    sayisalVerilerinToplami += st.nval;
                if (st.ttype == StreamTokenizer.TT_WORD) { //okunan veri metinsel mi?
                    kelimeSayisi++;                     //kelime sayısını bir arttır
                    karakterSayisi += st.sval.length(); //bulunan kelimedeki karakter sayısını hesapla
                }
            }

            System.out.println("Sayısal veriler toplamı: " +sayisalVerilerinToplami);
            System.out.println("Toplam kelime sayısı: " +kelimeSayisi);
            System.out.println("Toplam karakter sayısı: " +karakterSayisi);
        } catch (IOException e) {
            e.printStackTrace();
        }

        stringTokenizer("1asdfa.2adasd.3daasd.4asdad-5sds*6sdsds97sdsd,8sdsdd", ".-*9,");
    }

    public static void stringTokenizer(String s, String ayrac) {
        try {
            StringTokenizer strTok = new StringTokenizer(s, ayrac);
            while (strTok.hasMoreTokens()) {
                System.out.println("deger: " +strTok.nextToken());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
