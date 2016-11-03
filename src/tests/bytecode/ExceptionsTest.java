package tests.bytecode;

public class ExceptionsTest {
    static volatile int a;

    public static void main(String[] args) {
        a = test1();
        System.out.println("2: "+a);
    }

    static int test1(){
        try {
            a=3;
            test();
            return a;
        } catch (Exception e) {
            a=1;
            return a;
        } finally {
            a=2;
            System.out.println("finally: "+a);
//            return a;
        }
    }

    static void test() throws Exception{
        throw new Exception();
    }

}