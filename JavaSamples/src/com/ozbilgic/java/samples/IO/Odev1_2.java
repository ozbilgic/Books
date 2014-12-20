package com.ozbilgic.java.samples.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 17.12.2014
 */
public class Odev1_2 {
    public static void main(String[] args) {
        System.out.println("Dizin adı ve dosya tipi gir:");
        Scanner scan = new Scanner(System.in);
        String userInput = scan.next();

        File file;
        try {
            file = new File(userInput);
            String path = file.getParent();
            String fileName = file.getName();
            final String extension;
            int idx = fileName.lastIndexOf(".");
            extension = fileName.substring(idx);
            file = new File(path);
            String[] fileList = new String[0];
            if (file.isDirectory()) {
                fileList = file.list((dir, name) -> {
                    if (name.lastIndexOf('.') > 0) {
                        // '.' için index numarasını bul
                        int lastIndex = name.lastIndexOf('.');
                        // uzantıyı al
                        String str = name.substring(lastIndex);
                        // uzantıyı karşılaştır
                        if (str.equals(extension)) {
                            return true;
                        }
                    }
                    return false;
                });

                System.out.println("Dizinde bulunan benzer dosya listesi:");
                for (String s: fileList)
                    System.out.println(s);
            }

            System.out.println("bulunan dosyalar silinsin mi? e/h: ");
            userInput = scan.next();

            if (userInput.equals("e")) {
                for (String s: fileList) {
                    file = new File(path+"\\"+s);
                    if (file.isFile()) {
                        if (file.delete()) {
                            System.out.println(s + " dosyası silindi...");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
