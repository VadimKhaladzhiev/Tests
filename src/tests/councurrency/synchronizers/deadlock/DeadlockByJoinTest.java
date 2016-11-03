package tests.councurrency.synchronizers.deadlock;

public class DeadlockByJoinTest {
    public static void main(String[] args) {
        try {
            Thread curThread = Thread.currentThread();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        curThread.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread.sleep(1000);
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
