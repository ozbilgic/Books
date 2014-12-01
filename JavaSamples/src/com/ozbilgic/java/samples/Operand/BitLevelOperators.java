package com.ozbilgic.java.samples.Operand;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 01.12.2014
 */
public class BitLevelOperators {
    /**
     * Bit düzeyi: bir sayının ikilik düzendeki değeri
     * Sayısal veya karakter değişkenlerin üzerinde bit düzeyinde mantıksal işlem yapan operatörlerdir.
     * Bu işlemler sıkıştırma, şifreleme ve düşük kaynaklı cihazlarda hesaplama için kullanılabilir.
     * &: bit düzeyinde ve işlemi
     * |: bit düzeyinde veya işlemi
     * ^: bit düzeyinde ya da işlemi (özel veya)
     * ~: bit düzeyinde tümleme işlemi
     * >>: bit düzeyinde değerin sağındaki diğer değer kadar sağa öteleme
     * <<: bit düzeyinde değerin sağındaki diğer değer kadar sola öteleme
     * >>>: bit düzeyinde değerin sağındaki diğer değer kadar sağa öteleme (sıfır ile doldurarak)
     * @param args
     */
    public static void main(String[] args) {
        int i = 19; //bit değeri: 10011
        System.out.println(i + " to Binary: "+Integer.toBinaryString(i));

        int j = 16; //bit değeri: 10000
        System.out.println(j + " to Binary: "+Integer.toBinaryString(j));

        /**
         * Bit düzeyinde "ve" işlemi
         * VE operatörü kendi birinci işleneninin her bir bitini karşılık gelen ikinci
         * işlenenin bitiyle karşılaştırır. Her iki bit 1 ise, karşılık gelen sonuç biti
         * 1 olarak ayarlanır. Aksi durumda, karşılık gelen sonuç biti 0 olarak ayarlanır.
         * 19  1  0  0  1  1
         * &
         * 16  1  0  0  0  0
         * 16  1  0  0  0  0
         */
        System.out.println("Bit düzeyinde ve işlemi sonucu ("+i+" & "+j+"): "+ (i & j));

        /**
         * Bit düzeyinde "veya" işlemi
         * VEYA peratörü kendi birinci işleneninin her bir bitini karşılık gelen ikinci işlenenin
         * bitiyle karşılaştırır. Her iki bit 1 ise, karşılık gelen sonuç biti 1 olarak ayarlanır.
         * Aksi durumda, karşılık gelen sonuç biti 0 olarak ayarlanır.
         * 19  1  0  0  1  1
         * |
         * 16  1  0  0  0  0
         * 19  1  0  0  1  1
         */
        System.out.println("Bit düzeyinde veya işlemi sonucu ("+i+" | "+j+"): "+ (i | j));

        /**
         * Bit düzeyinde "ya da" işlemi
         * Özel VEYA peratörü kendi birinci işleneninin her bir bitini karşılık gelen ikinci işlenenin
         * bitiyle karşılaştırır. Bir bit 0 ve diğer bit 1 ise, karşılık gelen sonuç biti 1
         * olarak ayarlanır. Aksi durumda, karşılık gelen sonuç biti 0 olarak ayarlanır.
         * 19  1  0  0  1  1
         * ^
         * 16  1  0  0  0  0
         * 3   0  0  0  1  1
         */
        System.out.println("Bit düzeyinde özel veya işlemi sonucu ("+i+" ^ "+j+"): "+ (i ^ j));

        /**
         * Bit düzeyinde "değil" işlemi
         * ~
         * 19  1  0  0  1  1
         * -20 11111111111111111111111111101100
         */
        System.out.println("Bit düzeyinde tümleme işlemi sonucu ( ~ "+i+"): "+ (~i));

        /**
         * Bit düzeyinde değerin sağındaki diğer değer kadar sağa öteleme
         * 19  1  0  0  1  1
         * >>
         * 2
         * 4   1  0  0
         */
        System.out.println("Bit düzeyinde sağa kaydırma işlemi sonucu ("+i+" >> 2): "+ (i >> 2));

        /**
         * Bit düzeyinde değerin sağındaki diğer değer kadar sola öteleme
         * 19  1  0  0  1  1
         * <<
         * 2
         * 76  1  0  0  1  1  0  0
         */
        System.out.println("Bit düzeyinde sola kaydırma işlemi sonucu ("+i+" << 2): "+ (i << 2));

        /**
         * Bit düzeyinde değerin sağındaki diğer değer kadar sağa öteleme
         * 19  1  0  0  1  1
         * >>>
         * 2
         * 4  1  0  0
         */
        System.out.println("Bit düzeyinde sağa kaydırma işlemi sonucu ("+i+" >>> 2): "+ (i >>> 2));

        /**
         * Bu operatörler bit düzeyinde karşılaştırma için de kullanılabilir. Bu durumda,
         * her zaman ki kullanılan karşılaştırma operatörleriyle aynı işi görür.
         */
        System.out.println("bit düzeyinde 've' karşılaştırması: " + ((i+j) < 10 & i > 0));
        System.out.println("bit düzeyinde 'veya' karşılaştırması: " + ((i+j) < 10 | i > 0));
        System.out.println("bit düzeyinde 'ya da' karşılaştırması: " + ((i+j) < 10 ^ i > 0 && j+5 == 21));
    }
}
