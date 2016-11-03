package tests.councurrency.synchronizers.latch;

import tests.councurrency.Utils;

import java.util.concurrent.CountDownLatch;


/**
 * Один держит всех
 * Гарантируется, что Main thread будет напечано первым
 * Потоки запустятся только когда основной поток "откроет ворота" - понизит счетчик до нуля
 * Количество потоков известно заранее
 * */
public class CountDownLatchTest {
    public static void main(String[] args) {
        int nthreads = 3;
        CountDownLatch barrier = new CountDownLatch(1);
        for (int i = 0; i < nthreads; i++) {
            String name = String.format("Thread-%d", i);
            new Thread(() ->
            {
                try {
                    System.out.printf("%s : Started Work on %s\n", Utils.getFormattedDate(Utils.sdf), name);
                    Thread.sleep(Utils.getRandomWaitTime());
                    barrier.await();
                    System.out.printf("%s : Doing rest Work on %s\n", Utils.getFormattedDate(Utils.sdf), name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.printf("%s : Work completed %s\n", Utils.getFormattedDate(Utils.sdf), name);
            }).start();
        }
        System.out.println("Main thread work started");
        try {
            Thread.sleep(Utils.getRandomWaitTime());
            System.out.println("Latch");
            barrier.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
