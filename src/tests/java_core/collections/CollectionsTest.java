package tests.java_core.collections;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        performanceTest();
//        setTest();
//        listTest();
//        mapTest();
    }

    private static void performanceTest() {
        _performanceTest(new ArrayList<>());
        _performanceTest(new LinkedList<>());

        _performanceTest2(new ArrayList<>());
        _performanceTest2(new LinkedList<>());

        _performanceTest3(new ArrayList<>());
        _performanceTest3(new LinkedList<>());

    }

    /**
     * Вставка в начало списка
     * */
    private static void _performanceTest(List<Date> list) {
        long t1 = new Date().getTime();
        for (int i = 0; i < 3000000; i++) {
            list.add(new Date());
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }

    /**
     * Вставка в середину списка
     * */
    private static void _performanceTest2(List<Date> list) {
        long t1 = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            list.add(list.size()/2, new Date());
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }

    /**
     * Вставка в конец списка
     * */
    private static void _performanceTest3(List<Date> list) {
        long t1 = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            list.add(0, new Date());
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }

    private static void mapTest() {
        Map<Object, Object> map = new HashMap<>(4);
        map.put(2, "A");
        map.put(4, "B");
        map.put(8, "C");
        map.put(32, "D");
        System.out.println(map.size());
        for (Object o : map.values() ) {
            System.out.println(o);
        }
    }

    private static void listTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }

    private static void setTest() {
        Set<Object> set = new HashSet<>();
        Integer a = 300;
        Integer b = 300;
        Integer c = 3;
        Integer d = 4;
// Integer a = new Integer(2);
//        Integer b = new Integer(2);
//        Integer c = new Integer(3);
//        Integer d = new Integer(4);
        System.out.println(a==b);
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        System.out.println(set.size());
        for (Object o : set) {
            System.out.println(o.toString() + " " + System.identityHashCode(o));
        }
    }
}
