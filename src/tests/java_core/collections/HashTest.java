package tests.java_core.collections;

import java.util.HashSet;

public class HashTest {

    private String str;

    public HashTest(String str) {
        this.str = str;
    }

    public static void main(String args[]) {
        HashTest h1 = new HashTest("1");
        HashTest h2 = new HashTest("1");
        String s1 = new String("2");
        String s2 = new String("2");

        HashSet<Object> hs = new HashSet<Object>();
        hs.add(h1);
        hs.add(h2);
        hs.add(s1);
        hs.add(s2);

        System.out.print(hs.size());
    }
}
