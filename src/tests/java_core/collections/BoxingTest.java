package tests.java_core.collections;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Khaladzhiev on 27.09.2016.
 */
public class BoxingTest {
    public static int sum (List<Integer> ints) {
        int s = 0;
        for (int n : ints) { s += n; }
        return s;
    }

    public static Integer sumInteger(List<Integer> ints) {
        Integer s = 0;
        for (Integer n : ints) { s += n; }
        return s;
    }

    public static void main(String[] args) {
        List<Integer> smalls = Arrays.asList(1,2,3);
        System.out.println(sumInteger(smalls) == sumInteger(smalls));
        smalls = Arrays.asList(100,200,300);
        System.out.println(sumInteger(smalls) == sumInteger(smalls));
//        test1();
//        test2();
    }

    private static void test1() {
        List<Integer> bigs = Arrays.asList(100,200,300);
        System.out.println(sumInteger(bigs) == sum(bigs));
        System.out.println(sumInteger(bigs) == sumInteger(bigs));
    }

    private static void test2() {
        List<Integer> smalls = Arrays.asList(1,2,3);
        System.out.println(sumInteger(smalls) == sum(smalls));
        System.out.println(sumInteger(smalls) == sumInteger(smalls));
    }
}
