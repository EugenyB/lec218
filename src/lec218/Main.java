package lec218;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        bigValues();
//        randoms();
//        props();
//        dates();
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
        int[] a = new int[20_000_000];
//        int[] b = new int[20_000_000];
//        int[] c = new int[20_000_000];
//        int[] d = new int[20_000_000];
        System.out.println(runtime.freeMemory());
        try {
            Process process = runtime.exec("/opt/google/chrome/google-chrome --profile-directory=Default --app-id=clgddkicplcbgjfobecebadodeggpghp");
            Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void dates() {
        Locale locale = new Locale("en", "US");
        Locale.setDefault(locale);
        LocalDate now = LocalDate.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        System.out.printf("%f\n", 1_000_000.5);
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        System.out.println(date);
        Date tomorrow = new Date(118, 6, 12);
        Date q = new Date(30L*24*60*60*1000+date.getTime());
        System.out.println(tomorrow);
        System.out.println(q);

        LocalDate date1 = now.plusMonths(-2).minusDays(5);
        System.out.println(date1);
    }

    private static void props() {
        Properties properties = new Properties();
        try {
            properties.load(new BufferedReader(new FileReader("file.properties")));
            System.out.println(properties.get("User"));
            System.out.println(properties.get("Password"));
            properties.setProperty("Password", "789");
            System.out.println(properties.get("Password"));
            for (String s : properties.stringPropertyNames()) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void randoms() {
        Random rnd = new Random(43);
        System.out.println(rnd.nextInt(10));
        int[] array = rnd.ints(10,1,5).toArray();
        System.out.println(Arrays.toString(array));
    }

    private static void bigValues() {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= 100 ; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);

        BigDecimal big1 = BigDecimal.valueOf(1.0);
        BigDecimal big2 = BigDecimal.valueOf(3.0);
        BigDecimal res = big1.divide(big2, MathContext.DECIMAL128);
        System.out.println("res = " + res);

        BigInteger a = BigInteger.valueOf(1001);
        BigInteger b = BigInteger.valueOf(65);
        BigInteger[] dr = a.divideAndRemainder(b);
        System.out.println(dr[0] + " " + dr[1]);
    }
}
