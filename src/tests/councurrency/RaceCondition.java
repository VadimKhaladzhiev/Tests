package tests.councurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
Оператор вывода в потоке 2 выводит «x=1», хотя, казалось бы, переменная проверена на чётность.
потому что операция x++ не атомарна, не зависимо от volatile, помогает только синхронизация
*/
public class RaceCondition {
    private int x;
    private Lock lock = new ReentrantLock();
    private void run(){
        new Thread(()->{
            while (x<100000)
            {
                lock.lock();
                    x++;
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            while (x<100000){
                    if (x%2 == 0){
                        lock.lock();
                                if(x%2 != 0) System.out.println("x=" + x);
                        lock.unlock();
                    }
            }
        }).start();
    }
    public static void main(String[] args) {
        new RaceCondition().run();
    }
}
