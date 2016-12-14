package tests.java_core.ClassInteractionTest;

/**
 * Created by Khaladzhiev on 21.09.2016.
 */
public class A extends B{
    public static void print(){
        System.out.println("A");
    }
    public static void main(String[] args) {
       B a = new A();
        a.print();
    }
}
