/*
 * http://mishadoff.com/blog/java-magic-part-4-sun-dot-misc-dot-unsafe/
 * */
package tests.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    private UnsafeTest(){}

    public static void main(String[] args) {
        UnsafeTest obj = new UnsafeTest();

//        obj.noConstructorTest();
        obj.giveAccess();
    }

    private void giveAccess() {
        Guard guard = new Guard();
        System.out.println(guard.giveAccess());   // false, no access

        Unsafe unsafe = getUnsafe();

        try {
            Field f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
            unsafe.putInt(guard, unsafe.objectFieldOffset(f), 42); // memory corruption
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println(guard.giveAccess()); // true, access granted
    }

    private void noConstructorTest() {
        try {
            UnsafeTest.A o1 = new UnsafeTest.A(); // constructor
            System.out.println(o1.a()); // prints 1

            UnsafeTest.A o2 = UnsafeTest.A.class.getConstructor(this.getClass()).newInstance(this);
//            UnsafeTest.A o2 = cl.newInstance(this); // reflection
//            UnsafeTest.A o2 = UnsafeTest.A.class.newInstance(); // reflection
            System.out.println(o2.a()); // prints 1

            UnsafeTest.A o3 = (A) unsafe.allocateInstance(UnsafeTest.A.class); // unsafe
            System.out.println(o3.a()); // prints 0
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class Guard {
        private int ACCESS_ALLOWED = 1;

        public Guard(){}
        public boolean giveAccess() {
            return 42 == ACCESS_ALLOWED;
        }
    }

    private class A {
        private long a; // not initialized value
        Class cl;

        public A() {
            this.a = 1; // initialization
        }

        long a() { return this.a; }
    }

    static private Unsafe unsafe;

    static {
         unsafe = getUnsafe();
    }

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
