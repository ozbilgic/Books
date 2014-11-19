package com.ozbilgic.java.samples.primitive_type;

/**
 * Created Vision2 on 19.11.2014 - 17:23.
 */
public class PrimitiveType {
    public static void main(String[] args) {
        /**
         * INT | 4 byte - 32 bit | -2_147_483_648 & 2_147_483_647 | Aralıkta belirtilen Tamsayı değerlerini alır.
         * Arttırma ve eksiltme uygulanabilir i++, i--
         * Varsayılan değer: 0
         */

        int i = Integer.MIN_VALUE;
        System.out.println("int min: "+i);
        i = Integer.MAX_VALUE;
        System.out.println("int max: "+i);


        /**
         * LONG | 8 byte - 64 bit | -9223372036854775808 & 9223372036854775807 | Aralıkta belirtilen Tamsayı değerlerini alır.
         * Arttırma ve eksiltme uygulanabilir l++, l--
         * Varsayılan değer: 0l
         */

        long l = Long.MIN_VALUE;
        System.out.println("long min: "+l);
        l = Long.MAX_VALUE;
        System.out.println("long max: "+l);


        /**
         * CHAR | 2 byte - 16 bit | a..z & 0..9 | Tek karakter değer atanabilir.
         * Arttırma ve eksiltme uygulanabilir c++, c--
         * Varsayılan değer: \u0000
         */

        char c = 'a';
        System.out.println("char: "+c);
        c++;
        System.out.println("char++: "+c);


        /**
         * FLOAT | 4 byte - 32 bit | 1.4E-45 & 3.4028235E38 | Aralıkta belirtilen ondalıklı değerleri alabilir.
         * Virgülden sonra 3 basamağın değerini garanti eder.
         * Değerin sonuna 'f' karakterini eklemek zorunludur.
         * Arttırma ve eksiltme uygulanabilir f++, f--
         * Varsayılan değer: 0.0f
         */

        float f = Float.MIN_VALUE;
        System.out.println("float min: "+f);
        f = Float.MAX_VALUE;
        System.out.println("float max: "+f);
        f = 12.123f;
        System.out.println("float atama: "+f);


        /**
         * DOUBLE | 8 byte - 64 bit | 4.9E-324 & 1.7976931348623157E308 | Aralıkta belirtilen ondalıklı değerleri alabilir.
         * float' a göre daha büyük ve hassastır.
         * Arttırma ve eksiltme uygulanabilir f++, f--
         * Varsayılan değer: 0.0
         */

        double d = Double.MIN_VALUE;
        System.out.println("double min: "+d);
        d = Double.MAX_VALUE;
        System.out.println("double max: "+d);
        d = 12.12345678901234;
        System.out.println("double atama: "+d);


        /**
         * BYTE | 1 byte - 8 bit | -128 & 127 | Aralıkta belirtilen Tamsayı değerlerini alır.
         * Arttırma ve eksiltme uygulanabilir b++, b--
         * Varsayılan değer: 0
         */

        byte b = Byte.MIN_VALUE;
        System.out.println("byte min: "+b);
        b = Byte.MAX_VALUE;
        System.out.println("byte max: "+b);


        /**
         * SHORT | 2 byte - 16 bit | -32768 & 32767 | Aralıkta belirtilen Tamsayı değerlerini alır.
         * Arttırma ve eksiltme uygulanabilir s++, s--
         * Varsayılan değer: 0
         */

        short s = Short.MIN_VALUE;
        System.out.println("short min: "+s);
        s = Short.MAX_VALUE;
        System.out.println("short max: "+s);


        /**
         * BOOLEAN | 1 bit | false & true | Sadece false veya true değerlerini alabilir.
         * Varsayılan değer: false
         */

        boolean bool = Boolean.TRUE;
        System.out.println("boolean: "+bool);
        bool = Boolean.FALSE;
        System.out.println("boolean: "+bool);

        /**
         * String tipi primitive yani ilkel veri tipleri arasına girmediği için burada yer almamıştır.
         */
    }
}
