package tests.java_core;

// javap -c tests.java_core.StaticMethodTest

class StaticMethodTest {

    void test() {
        System.out.println("test1");
    }

    private static void test2() {
        System.out.println("test1");
    }

    void test(Number a) {
        System.out.println("test1 + Number");
    }
}

class Test3 extends StaticMethodTest {
    void test() {
        System.out.println("test2");
    }

    static void test2() {
        System.out.println("test2");
    }

    void test(Long a) {
        System.out.println("test3 + Long");
    }


}

class T extends Test3 {

    void test() {
        System.out.println("test3");
    }

    void test(String a) {
        System.out.println("test3 + String");
    }

    void test(Number a) {
        System.out.println("test3 + Number");
    }

    static void test2() {
        System.out.println("test3");
    }

    public static void main(String[] args) {

        T tes = new T();
//        ((Test3) tes).test();
//        tes.test();
        ((StaticMethodTest) tes).test(1D);

    }

}