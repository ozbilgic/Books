package com.ozbilgic.java.samples.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 11.12.2014
 */
public class FileDirectory {
    public static void main(String[] args) {
        String sep = File.separator + File.separator;
        File file = new File("C:" + sep + "JAVA" + sep + "java.txt"); //dosya işlemleri için referans

        if (file.exists()) {
            System.out.println("dosya okunabilir: " + file.canRead()); //dosya okunabilir mi?
            System.out.println("dosya yazılabilir: " + file.canWrite()); //dosya yazılabilir mi?

            /**
             * Karşılaştırılan dosyalar birbirine eşit mi?
             * her açıdan dosylar eşitse "0" sıfır değeri döner.
             * Not: dosyanın bire bir kopyası bile olsa eşit görmüyor buda sanırım
             * oluşturulduğu zamanla ilgili olsa gerek.
             */
            if (file.compareTo(new File("C:" + sep + "JAVA" + sep + "java.txt")) == 0) {
                System.out.println("java.txt ile java.txt birbirine eşit");
            }
        }

        try {
            if (file.createNewFile()) //aynı isimde dosya yoksa belirtilen isimde yeni oluştur.
                System.out.println("java.txt dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * windows için C:\Users\oturum_adi\AppData\Local\Temp
         * klasörü içine ön ek + rastgele ek konarak dosya oluşturur.
         * ayrıca oluşturulacak dizini bizim de belirtebileceğimiz metoduda bulunmaktadır.
         */
        try {
            file = File.createTempFile("temp", ".txt"); //suffix null olursa varsayılan değer ".tmp" atanır.
            System.out.println("temp dosyası oluşturuldu: '"+file.getName()+"'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //if (file.delete()) //dosya adı yerine klasör adı değeri verilmişse klasörü siler.
            //System.out.println(file.getName()+" dosyası silindi.");

        file.deleteOnExit(); //program çıkışında belirtilen dosyayı sil.

        file = new File("C:" + sep + "JAVA" + sep + "java.pdf");
        if (file.equals(new File("C:" + sep + "JAVA" + sep + "java.txt"))) //dosya yollarını karşılaştır.
            System.out.println("dosya referansları aynı");

        System.out.println("mutlak dosya yolu: "+file.getAbsolutePath());
        System.out.println("dosya yolu: "+file.getPath());
        System.out.println("dosya adı: "+file.getName());
        System.out.println("klasör yolu: "+file.getParent());
        if (file.isDirectory()) System.out.println("bu bir klasör"); else System.out.println("bu bir klasör değil");
        if (file.isFile()) System.out.println("bu bir dosya"); else System.out.println("bu bir dosya değil");
        if (file.isHidden()) System.out.println("gizli dosya"); else System.out.println("gizli dosya değil");
        System.out.println("son değişiklik tarihi: "+ new Date(file.lastModified()));
        //karakter sayısını gösteriyor buda byte demek yani mb ye çevirmek için 2 kez 1024 e bölmek gerekiyor.
        System.out.println("dosya boyutu: "+ file.length());
        file = new File("C:" + sep + "JAVA");
        if (file.isDirectory()) { //hata kontrolü için gerekli.
            String[] fileList = file.list(); //belirtilen klasördeki dosya isimlerini alır.
            for (String f : fileList)
                System.out.println("dosya adı: " + f);
        }
    }
}
