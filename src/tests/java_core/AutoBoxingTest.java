package tests.java_core;

/**
 * Created by Khaladzhiev on 01.12.2016.
 */
public class AutoBoxingTest {
    static void test(Integer i){}
    public static void main(String[] args) {
        Integer a = 5555;
        Integer l = a * 2;

        new AutoBoxingTest().test(l);
    }
}
