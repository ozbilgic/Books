package com.ozbilgic.java.samples.IO;

import java.io.*;
import java.util.Date;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 11.12.2014
 */
public class FileDirectory {
    public static String lnxPath;

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
            System.out.println("temp path: "+file.getAbsolutePath());
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

        /**
         * list() metodundan farkı bulunan dosyaları File nesnesine atamak
         * dolayısı ile dosyalar üzerinde işlem yapılabilir.
         */
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            try {
                for (File f : files) // klasör de hiç dosya yoksa NullPointerException hatası verir.
                    System.out.println("dosya adı: " + f.getName() + " dosya mı?: " + f.isFile());
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * Sistemde bulunan kök dizinleri verir yani c: d: e: gibi...
         */
        File[] kokDizinler = File.listRoots();
        for (File f: kokDizinler)
            System.out.println(f);

        //file.mkdir(); belirtilen yolda klasör oluşturur. dönüş tipi boolean.
        //file.renameTo(new File("...")); belirtilen yoldaki klasör veya dosya adını değiştirir. dönüş tipi boolean.
        //file.setReadOnly(); belirtilen yoldaki dosyayı sadece okunabilir yapmak için. dönüş tipi boolean.
        //file.setWritable(true - false); dosyayı yazılabilir-değiştirilebilir duruma getirir. boolean.
        System.out.println(file.toString()); //dosya yolunu string olarak döndürür.

        lnxPath = "C:"+sep+"JAVA";//+sep+"ozbilgic";
        File lnxFile;// = new File(lnxPath);

        /*
        String[] lnxFileList = lnxFile.list();
        for (String s: lnxFileList)
            System.out.println(s);
            */

        lnxPath += sep+"java_denemeler";
        lnxFile = new File(lnxPath);
        if (lnxFile.mkdir())
            System.out.println("klasör oluşturuldu");

        lnxPath += sep+"test.txt";
        lnxFile = new File(lnxPath);
        try {
            if (lnxFile.createNewFile())
                System.out.println("dosya oluşturuldu");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        InputStream inStream;
        byte[] data = new byte[0xff];
        try {
            inStream = new FileInputStream(lnxPath);
            int byt;
            System.out.println("byte sayısı: "+inStream.available());
            while ((byt = inStream.read(data)) != -1) {
                //inStream.skip(2); //2 byte lık veriyi atlar
                //System.out.print((char)byt);
                for (byte b: data) {
                    System.out.print((char) b);
                }
            }
            inStream.close();
        } catch (IOException e) {
            System.out.println("hata oluştu: "+e.getMessage());
        }

        BufferedInputStream buffStream;
        try {
            inStream = new FileInputStream(lnxPath);
            buffStream = new BufferedInputStream(inStream, inStream.available());
            int byt;
            if (buffStream.markSupported()) System.out.println("mark destekliyor"); else System.out.println("mark desteklemiyor");
            boolean dongu = false;
            while ((byt = buffStream.read()) != -1) {
                System.out.print((char)byt);
                if (byt == 122) { //z
                    buffStream.mark(0);
                    System.out.println("\n'z' harfine işaret konuldu.");
                    //return;
                }
            }

            System.out.println("\nişaretli yerden itibaren tekrar oku");
            buffStream.reset();
            while ((byt = buffStream.read()) != -1) {
                System.out.print((char)byt);
            }

            inStream.close();
            buffStream.close();
        } catch (IOException e) {
            System.out.println("hata oluştu: "+e.getMessage());
        }
        System.out.println();

        BufferedInputStream bf = buffMarkReader(lnxPath, 'e');
        buffMarkAfterReader(bf);
    }

    /**
     * Belirtilen yoldaki dosyanın içeriğini belirtilen karaktere kadar okuduktan sonra o harfe işaret koyar
     * @param path Dosya yolu.
     * @param c İşaretlenecek karakter.
     * @return BufferedInputStream.
     */
    public static BufferedInputStream buffMarkReader(String path, char c) {
        InputStream inStream;
        BufferedInputStream buffinStream;
        int character = (int)c;
        System.out.println("karakter: "+(char)character);

        try {
            inStream = new FileInputStream(path);
            buffinStream = new BufferedInputStream(inStream, inStream.available());
            int byt;

            while ((byt = buffinStream.read()) != -1) {
                System.out.print((char)byt);
                if (byt == character) {
                    buffinStream.mark(0);
                    return buffinStream;
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return null;
    }

    /**
     * Gelen parametre değerindeki streamı işaretlenen karaktere döndürür ve geriye kalanı okur.
     * @param buffinStream BufferedInputStream.
     */
    public static void buffMarkAfterReader(BufferedInputStream buffinStream) {
        try {
            int byt;
            buffinStream.reset();
            while ((byt = buffinStream.read()) != -1) {
                System.out.print((char)byt);
            }
            buffinStream.close();
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
