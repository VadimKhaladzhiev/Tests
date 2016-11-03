package tests.councurrency.synchronizers.barrier;

import tests.councurrency.Utils;

import java.util.concurrent.CyclicBarrier;


/**
 * Все потоки ждут остальные потоки прежде чем перейти ко второй части, затем к третьей
 * Количество потоков известно заранее
 * */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
            private int count = 1;

            public void run() {
                System.out.printf("Cyclic Barrier Finished %d\n", count++);
            }
        });
        System.out.println("Spawning Threads");
        for (int i = 0; i < 4; i++) {
            String name = String.format("Thread-%d", i);
            new Thread(getRunnable(barrier, name)).start();
        }
        System.out.println("Spawning Finished");
    }

    private static Runnable getRunnable(CyclicBarrier barrier, String name) {
        return () ->
        {
            try {
                int count = barrier.await();
                System.out.printf("%s : 1st part of Work on %s\n", Utils.getFormattedDate(Utils.sdf), name);
                Thread.sleep(Utils.getRandomWaitTime());
                barrier.await();
                System.out.printf("%s : Cyclic Barrier count on %s is %d\n", Utils.getFormattedDate(Utils.sdf), name, count);
                System.out.printf("%s : 2nd part of Work on %s\n", Utils.getFormattedDate(Utils.sdf), name);
                Thread.sleep(Utils.getRandomWaitTime());
                barrier.await();
                System.out.printf("%s : 3rd part of Work on %s\n", Utils.getFormattedDate(Utils.sdf), name);
                Thread.sleep(Utils.getRandomWaitTime());
                System.out.printf("%s : Work completed %s\n", Utils.getFormattedDate(Utils.sdf), name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
