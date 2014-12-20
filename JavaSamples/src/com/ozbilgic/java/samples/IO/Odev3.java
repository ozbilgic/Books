package com.ozbilgic.java.samples.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 17.12.2014
 */
public class Odev3 {
    private static final String SEP = File.separator;

    public static void main(String[] args) {
        System.out.println(">> Dizin gir:");
        Scanner scan = new Scanner(System.in);
        final String userEntered = scan.next();
        System.out.println(">> Arşiv ismi gir:");
        final String archiveName = scan.next();

        zip(userEntered, archiveName);

    }

    //dosyaları ve varsa iç içe olmayan klasörleri ve içeriğini sıkıştırır.
    public static void zip(String path, String archiveName) {
        File file = new File(path);
        String[] fList = file.list();

        if (fList.length <= 0)
            System.out.println(">> Dizin boş...");
        else {
            ZipOutputStream zos;
            FileInputStream finst = null;
            try {
                zos = new ZipOutputStream(new FileOutputStream(path+SEP+archiveName+".zip"));
                byte[] b = new byte[0x400];
                int len;

                for (String s: fList) {
                    if (new File(path+SEP+s).isFile()) {
                        finst = new FileInputStream(path+SEP+s);
                        zos.putNextEntry(new ZipEntry(s));
                        while ((len = finst.read(b)) > 0) zos.write(b, 0, len);
                    } else {
                        //createFolderInZip(zos, path, s);
                        /*
                        file = new File(path+SEP+s);
                        String[] list = file.list();
                        zos.putNextEntry(new ZipEntry(s+"/"));

                        for (String str: list) {
                            finst = new FileInputStream(path+SEP+s+SEP+str);
                            zos.putNextEntry(new ZipEntry(s+SEP+str));
                            while ((len = finst.read(b)) > 0) zos.write(b, 0, len);
                        }
*/
                    }
                }

                zos.flush();
                zos.close();
                if (finst != null) finst.close();
                System.out.println(">> Sıkıştırma tamamlandı.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createZip(String path, String archiveName) throws IOException {
        final String SEP = File.separator;
        File file = new File(path);
        String parent;
        String fileName;
        String[] fList = file.list();
        ZipOutputStream zos;

        if (file.isDirectory()) {
            if (fList.length == 0) {
                zos = new ZipOutputStream(new FileOutputStream(path + SEP + archiveName + ".zip"));
                zos.putNextEntry(new ZipEntry(path+"/"));
                zos.close();
            } else {
                /*
                parent = file.getParent();
                fileName = file.getName();
                byte[] b = new byte[0x400];
                int len;

                zos.putNextEntry(new ZipEntry(directory + "/"));
                for (String _file : fList) {
                    if (new File(path + SEP + directory + SEP + _file).isFile()) {
                        FileInputStream fis = new FileInputStream(path + SEP + directory + SEP + _file);
                        zos.putNextEntry(new ZipEntry(directory + SEP + _file));
                        while ((len = fis.read(b)) > 0) zos.write(b, 0, len);
                    } else createFolderInZip(zos, path + SEP + directory, _file);
                }
                */
            }
        }
    }

/*
    public static void createFolderInZip(ZipOutputStream zos, String path, String directory) {
        File file = new File(path+SEP+directory);
        String[] fList = file.list();
        byte[] b = new byte[0x400];
        int len;
        try {
            zos.putNextEntry(new ZipEntry(directory+"/"));
            for (String _file: fList) {
                if (new File(path+SEP+directory+SEP+_file).isFile()) {
                    FileInputStream fis = new FileInputStream(path+SEP+directory+SEP+_file);
                    zos.putNextEntry(new ZipEntry(directory+SEP+_file));
                    while ((len = fis.read(b)) > 0) zos.write(b, 0, len);
                } else createFolderInZip(zos, path+SEP+directory, _file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    public static void unZip(String zipFile) {

    }
}
