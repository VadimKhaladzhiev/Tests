package tests.java8;

public class LambdaTest {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("test"));
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("test");
//            }
//        });
    }
//    class Test{}
}
