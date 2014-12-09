package com.ozbilgic.java.samples;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 04.12.2014
 */
public class Test {
    int i;
    static int j = 0;
    private String name;

    public Test(String name) {
        this.name = name;
        j++;
    }

    void mesaj(String msg) {
        System.out.println(msg);
    }

    public static int toplam() {
        return j;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Test sınıfından nesne silindi. ("+name+")");
        j = 0;
    }
}
