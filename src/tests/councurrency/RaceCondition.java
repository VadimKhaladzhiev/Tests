package tests.councurrency;

//Оператор вывода в потоке 2 выводит «x=1», хотя, казалось бы, переменная проверена на чётность.
public class RaceCondition {
    private volatile int x;
    private void run(){
//        new Thread(()->{
//            while (x<100000)
//            {
//                x++;
//            }
//        }).start();
//        new Thread(()->{
//            while (x<100000){
//                if (x%2 == 0)
//                    System.out.println("x=" + x);
//            }
//        }).start();
    }
    public static void main(String[] args) {
        new RaceCondition().run();
    }
}
