package tests.java_core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * -XX:hashCode=n
 * 0 – Park-Miller RNG (default)
 * 1 – f(address, global_statement)
 * 2 – constant 1
 * 3 – Serial counter
 * 4 – Object address
 * 5 – Thread-local Xorshift
 *
 */
public class HashCodeTest {
    public static void main(String[] args) {
        hashMapTest();
//        printHashCode();
    }

    private static void hashMapTest() {
        Map<Object, Integer> map = new HashMap<Object, Integer>();
        for (int i = 0; i < 23; i++) {
            map.put(new Object(), 1);
        }
        System.out.println("Size: "+map.size());
    }

    private static void printHashCode() {
        long start = new Date().getTime();
        for (int i = 0; i < 1000; i++) {
            System.out.println(new Object().hashCode());
        }
        long end = new Date().getTime();
        System.out.println((end-start));
    }
}
