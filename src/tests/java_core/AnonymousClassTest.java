package tests.java_core;

public class AnonymousClassTest {
    private void test(Runnable visitor){
        visitor.run();
    }
    private void test3(){}

    private void test2(){
        test(new Runnable() {
                 @Override
                 public void run() {
                     test3();
                 }
             }
        );
    }

    public static void main(String[] args) {
        AnonymousClassTest test  = new AnonymousClassTest();
        test.test2();
    }
}
