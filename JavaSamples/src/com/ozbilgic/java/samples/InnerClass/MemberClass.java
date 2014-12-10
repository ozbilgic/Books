package com.ozbilgic.java.samples.InnerClass;

import com.ozbilgic.java.samples.Test;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 09.12.2014
 */
public class MemberClass {
    /**
     * DAHILI SINIFLAR
     * -> Dahili sınıflar iç içe tanımlanmış sınıflardır.
     * -> public, protected, friendly, private ve static kullanılabilir.
     */

    public static class Hesapla {
        public Hesapla() {
            System.out.println("Constructor = Hesapla");
        }

        public class DortIslem {
            public DortIslem() {
                System.out.println("Constructor = DortIslem");
            }

            public class Topla { //public heryerden erişilebilir.
                public void Toplam(int sayi1, int sayi2) {
                    System.out.println("toplam: " + (sayi1 + sayi2));

                    class YerelSinif extends Test { //herhangi bir yerden erişilemez. Sadece metod içinde geçerli.
                        private String name;

                        public YerelSinif(String name) {
                            super(name);
                            this.name = name;
                        }

                        public void yerelSinif() {
                            System.out.println(name);
                        }
                    }

                    YerelSinif yerelSinif = new YerelSinif("YEREL SINIF");
                    yerelSinif.yerelSinif();
                    System.out.println("Test sınıfı nesne sayısı: "+Test.toplam());
                }
            }

            class cikart { //friendly aynı paket içerisinde erişilebilir.
                public void cikar(int sayi1, int sayi2) {
                    System.out.println("cikart: " + (sayi1 - sayi2));
                }
            }

            protected class carp { //protected aynı paket içerisinde erişilebilir.
                public void carpim(int sayi1, int sayi2) {
                    System.out.println("carp: " + (sayi1 * sayi2));
                }
            }

            private class bol { //private dışarıdan (başka bir paketten) erişime kapalı, sadece kendi içerisinde erişilebilir.
                public void bolum(int sayi1, int sayi2) {
                    System.out.println("bol: " + (sayi1 / sayi2));
                }
            }
        }
    }

    //STATIC olarak tanımlamada new anahtar kelimesini kullanmaya gerek kalmaz.
    public static class Hesapla2 {
        public Hesapla2() {
            System.out.println("Constructor = Hesapla");
        }

        public static class DortIslem {
            public DortIslem() {
                System.out.println("Constructor = DortIslem");
            }

            public static class Topla { //public heryerden erişilebilir.
                public static void Toplam(int sayi1, int sayi2) {
                    System.out.println("toplam: "+(sayi1+sayi2));
                }
            }

            static class cikart { //friendly aynı paket içerisinde erişilebilir.
                public static void cikar(int sayi1, int sayi2) {
                    System.out.println("cikart: "+(sayi1-sayi2));
                }
            }

            protected static class carp { //protected aynı paket içerisinde erişilebilir.
                public static void carpim(int sayi1, int sayi2) {
                    System.out.println("carp: "+(sayi1*sayi2));
                }
            }

            private static class bol { //private dışarıdan (başka bir paketten) erişime kapalı, sadece kendi içerisinde erişilebilir.
                public static void bolum(int sayi1, int sayi2) {
                    System.out.println("bol: "+(sayi1/sayi2));
                }
            }
        }
    }

    public static class A {
        public A() {
            System.out.println("A sınıfı");
        }

        public void msg() {
            System.out.println("A");
        }
    }

    public static class B extends A {
        public B() {
            System.out.println("B sınıfı");
        }

        @Override
        public void msg() {
            System.out.println("B");
        }
    }

    public static class C extends B {
        public C() {
            System.out.println("C sınıfı");
        }

        @Override
        public void msg() {
            System.out.println("C");
        }
    }

    public static void msg(A polimorfizm) {
        polimorfizm.msg();
    }

    public static void main(String[] args) {
        Hesapla.DortIslem.Topla topla = new Hesapla().new DortIslem().new Topla();
        topla.Toplam(5, 10);

        Hesapla.DortIslem.cikart cikart = new Hesapla().new DortIslem().new cikart();
        cikart.cikar(12, 3);

        Hesapla.DortIslem.carp carp = new Hesapla().new DortIslem().new carp();
        carp.carpim(4, 7);

        Hesapla.DortIslem.bol bol = new Hesapla().new DortIslem().new bol();
        bol.bolum(8, 2);

        //STATIC
        Hesapla2.DortIslem.Topla.Toplam(3, 8);
        Hesapla2.DortIslem.cikart.cikar(5, 9);
        Hesapla2.DortIslem.carp.carpim(4, 2);
        Hesapla2.DortIslem.bol.bolum(9, 3);

        A a = new A();
        B b = new B();
        C c = new C();

        msg(a);
        msg(b);
        msg(c);
    }
}
