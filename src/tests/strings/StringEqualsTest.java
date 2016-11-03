package tests.strings;

/**
 * Created by Khaladzhiev on 12.09.2016.
 */
public class StringEqualsTest {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();

        test4();
    }

    private static void test4() {
        char a [] = new char[]{'g','h','j'};
        String string = new String(a);
        a[0]='d';
        String internString = string.intern();
        String string2 = "ghj";
        System.out.println(internString==string2);
    }

    private static void test1() {
        String a = new String("test");
        String b = new String("test");
        System.out.println(a == b);
    }

    private static void test2() {
        String a = "test";
        String b = "test";
        System.out.println(a == b);
    }

    private static void test3() {
        String a = new String("test");
        String b = new String("test");
        System.out.println(a.getBytes() == b.getBytes());
    }
}
