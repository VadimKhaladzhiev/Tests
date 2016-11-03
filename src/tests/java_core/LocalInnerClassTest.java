package tests.java_core;

public class LocalInnerClassTest {
    void test(){
        int a=11111;
        class T implements Runnable{
            @Override
            public void run() {
                System.out.println(a);
            }
        }
        T r = new T();
    }

    public static void main(String[] args) {
        LocalInnerClassTest test = new LocalInnerClassTest();
        test.test();
    }
}
