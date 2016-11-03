package tests.java_core.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Khaladzhiev on 09.08.2016.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Comparable> map = new HashMap<>();
        map.put(null, "a");
        map.put(null, "b");

        System.out.println(map);

//        System.out.println(HashMapTest.class.hashCode());
//        System.out.println(hash(HashMapTest.class));
    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
