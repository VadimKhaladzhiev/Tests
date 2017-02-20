package tests.java_core.collections;

import java.util.*;


public class CollectionsTest {
    public static void main(String[] args) {
        insert();
        remove();
    }

    private static void remove() {
        removeFirst(new ArrayList<>());
        removeFirst(new LinkedList<>());

        removeMiddle(new ArrayList<>());
        removeMiddle(new LinkedList<>());

        removeLast(new ArrayList<>());
        removeLast(new LinkedList<>());
    }

    private static void insert() {
        insertFirst(new ArrayList<>());
        insertFirst(new LinkedList<>());

        insertLast(new ArrayList<>());
        insertLast(new LinkedList<>());

        insertMiddle(new ArrayList<>());
        insertMiddle(new LinkedList<>());

        insertMiddleIterator(new ArrayList<>());
        insertMiddleIterator(new LinkedList<>());
    }

    /**
     * Вставка в начало списка
     * */
    private static void insertFirst(List<Date> list) {
        System.out.println("Вставка в начало списка "+list.getClass() );
        list.add(new Date());
        long t1 = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            list.add(0, new Date());
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }

    /**
     * Вставка в конец списка
     * */
    private static void insertLast(List<Date> list) {
        System.out.println("Вставка в конец списка "+list.getClass());
        long t1 = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            list.add(0, new Date());
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }

    /**
     * Вставка в середину списка
     * */
    private static void insertMiddle(List<Date> list) {
        System.out.println("Вставка в середину списка "+list.getClass());
        initList(list);
        long t1 = new Date().getTime();
        for (int i = 0; i < 3000; i++) {
            list.add(190000, new Date());
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }

    /**
     * Вставка в середину списка через итератор
     * */
    private static void insertMiddleIterator(List<Date> list) {
        System.out.println("Вставка в середину списка через итератор "+list.getClass() );
        initList(list);
        ListIterator iterator = list.listIterator(19000);

        long t1 = new Date().getTime();
        for (int i = 0; i < 3000; i++) {
            iterator.add(new Date());
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }

    /**
     * Удаление из начала списка
     * */
    private static void removeFirst(List<Date> list) {
        System.out.println("Удаление из начала списка "+list.getClass() );
        initList(list);
        long t1 = new Date().getTime();
        for (int i = 0; i < 1000; i++) {
            list.remove(0);
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }

    /**
     * Удаление из середины списка
     * */
    private static void removeMiddle(List<Date> list) {
        System.out.println("Удаление из середины списка "+list.getClass() );
        initList(list);
        long t1 = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            list.remove(1000);
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }


    /**
     * Удаление из конца списка
     * */
    private static void removeLast(List<Date> list) {
        System.out.println("Удаление из конца списка "+list.getClass() );
        initList(list);
        long t1 = new Date().getTime();
        for (int i = 0; i < 1000000; i++) {
            list.remove(list.size()-1);
        }
        long t2 = new Date().getTime();
        System.out.println(t2-t1 + " " + list.size());
    }


    private static void initList(List<Date> list) {
        for (int i = 0; i < 1000000; i++) {
            list.add(new Date());
        }
    }
}
