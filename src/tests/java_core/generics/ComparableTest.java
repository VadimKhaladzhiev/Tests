package tests.java_core.generics;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComparableTest {
    enum Season { WINTER, SPRING, SUMMER, FALL }
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<Number> list = new ArrayList<>();
        list = (List<Number>)(List<?>)intList;
        list.addAll(intList);

        A<Date> a = new B<>(new Date());
        a.b(new ArrayList<Time>());
        Date d = a .test();
        A<Date>[] aArray = new B<?>[10];
        aArray[0] = new B<>(d);
        for (A a1: aArray) {
            if(a1!=null)System.out.println(a1.a);
        }
    }
}

class A<T> {
    T a;
    void b(List<? extends T> d){}
    T test() {
        System.out.println("A");
        return null;
    }
    Object s(){return null;}
}

class B<T extends Date> extends A<Date> {

    B(Date d){a = d;}
    Date test(){
        System.out.println("B");
        return a;
    }
    Date s(){return null;}
}
