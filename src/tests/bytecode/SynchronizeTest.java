package tests.bytecode;

/**
 * Created by Khaladzhiev on 19.09.2016.
 */
public class SynchronizeTest {
    public static void main(String[] args) {
        int a=0;
        synchronized(SynchronizeTest.class) {
            a++;
        }
    }
}
