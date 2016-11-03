package tests.java_core.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForeachTest {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        List<Integer> list = Arrays.asList(arr);
        for (Integer i: list) {
            System.out.println(i);
        }
        for (Integer i: arr) {
            System.out.println(i);
        }
        List list2 = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Object i: list2) {
            System.out.println(i);
        }
    }
}
