package tests.councurrency.synchronizers.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ограничиваем выполнение потоков одновременно не более двух
 * */

public class SemaphoreTest {
    static AtomicInteger completed;

    public static void main(String[] args) {
        int nThreads = 6;
        int capacity = 2;
        completed = new AtomicInteger();
        Semaphore barrier = new Semaphore(capacity);

        for (int i = 1; i <= nThreads; i++) {
            new Thread(() -> {

                    try {
                        barrier.acquire();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " started");
                    completed.getAndIncrement();
            }).start();

        }

        int queue;
        for (;;){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(barrier.hasQueuedThreads()){
                queue = barrier.getQueueLength();
                System.out.println(queue);
                barrier.release(capacity);
            }
            if(completed.get()>=nThreads)break;
        }

    }
}
