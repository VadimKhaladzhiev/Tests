package tests.java_core.ClassInteractionTest;

/**
 * Created by Khaladzhiev on 23.09.2016.
 */
public class C {
    static C c;
    public static void main(String[] args) {
        System.out.println("test");
        c = new C();
    }
}
