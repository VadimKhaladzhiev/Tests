package tests.strings;

import java.lang.management.ManagementFactory;

public class StringTests {
    public static void main(String[] args) {
        String a = new String("tbm1");
        String b = new String("tbm1");
        String c = new String("tbm2");
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        try {
            Thread.currentThread().sleep(6000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
