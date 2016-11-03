package tests.java_core;

import java.util.Random;

/**
 * Created by Khaladzhiev on 22.06.2016.
 */
public class RandomTest {
    private static Random rand = new Random(100);
    public static void main(String[] args) {
        for(int i =0 ; i<10; i++){
            System.out.println(i + " : " + rand.nextInt(5000));
        }
    }
}
