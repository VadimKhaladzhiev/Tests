package tests.java_core.collections;

import java.util.*;

/**
 * Created by Khaladzhiev on 20.09.2016.
 */
public class GenericsTest
{
    public static void main(String[] args) {
        Integer[] ints = new Integer[] {1,2,3};
        Number[] nums = ints;
        nums[2] = 3.14;

//        test1();
//        test2();
//        test3();
    }

    private static void test3() {
        List<Number> ints = new ArrayList<Number>();
        ints.add(1);
        ints.add(2);
        ints.add(3.14);
        System.out.println(ints.toString());
    }

    private static void test2() {
        List<Integer> ints = Lists.toList(new Integer[] { 1, 2, 3 });
        List<String> words = Lists.toList(new String[] { "hello", "world" });

        List<Integer> ints2 = Lists.<Integer>toList();
        List<Object> objs = Lists.<Object>toList(1, "two");
    }

    private static void test1() {
        List<Number> list = new ArrayList<Number>();
        List<Number> list1 = (List<Number>)list;
        list1.add(new Double(1.2));
        List<Date> list2 = (List<Date>)(List<?>)list;
        list2.add(new Date());
        for(Date date : list2){
            date.getTime();
        }
        System.out.println(list2);
    }

    public static double sumCount(Collection<Number> nums, int n) {
        count(nums, n);
        return sum(nums);
    }

    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) ints.add(i);
    }

    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) s += num.doubleValue();
        return s;
    }

    public static <T> void copy(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }
}
class Lists {
    public static <T> List<T> toList(T... arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }
}
