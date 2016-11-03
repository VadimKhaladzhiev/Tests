package tests.java_core;

/**
 * Created by Khaladzhiev on 18.10.2016.
 */
public class ClassCastTest {
    public static void main(String[] args) {
        Long a = new Long(1L);
//        Integer b = (Integer)a;
        System.out.println(a instanceof Number);
    }
}
