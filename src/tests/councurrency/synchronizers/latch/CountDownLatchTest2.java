//http://shazsterblog.blogspot.ru/2011/12/comparison-of-countdownlatch.html
package tests.councurrency.synchronizers.latch;

import tests.councurrency.Utils;

import java.util.concurrent.*;
/**
 * Несколько держат одного
 * Main ждет когда откроется затвор (latch)
 * Каждый поток после работы, уменьшает счетчик на 1 (первоначально счетчик равен количеству потоков)
 * */
public class CountDownLatchTest2 {
    private static final int MAX_THREADS = 5;

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(MAX_THREADS);

        System.out.println("Spawning Threads");
        for(int i=0;i<MAX_THREADS;i++) {
            Thread t = new Thread(new WorkerThread(countDownLatch, String.format("Thread-%d", i)));
            t.start();
        }
        System.out.println("Spawning Finished");
        System.out.println("Waiting All Threads to Finish");
        countDownLatch.await(); // Await is void
        System.out.println("All Threads are Finished");
    }

    private static class WorkerThread implements Runnable {
        private CountDownLatch countDownLatch;

        private String name;

        WorkerThread(CountDownLatch countDownLatch, String name) {
            this.name = name;
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            try {
                System.out.printf("%s : Doing Some Work on %s\n", Utils.getFormattedDate(Utils.sdf), name);
                Thread.sleep(Utils.getRandomWaitTime());
                System.out.printf("%s : Doing Some more work on %s\n", Utils.getFormattedDate(Utils.sdf), name);
                Thread.sleep(Utils.getRandomWaitTime());
                System.out.printf("%s : Finished work on %s\n", Utils.getFormattedDate(Utils.sdf), name);
                countDownLatch.countDown();
                System.out.printf("%s : Count Down Latch count on %s is %d\n", Utils.getFormattedDate(Utils.sdf), name, countDownLatch.getCount());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
}
