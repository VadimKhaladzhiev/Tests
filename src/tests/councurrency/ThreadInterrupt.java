package tests.councurrency;

/**
 * Created by Khaladzhiev on 10.10.2016.
 */
public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread started");
                    Thread.sleep(10000);
                    System.out.println("Thread completed");
                } catch (InterruptedException e) {
                    System.out.println("Exception .......................");
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.start();
        System.out.println("Start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("isInterrupted ? " + t.isInterrupted());
        System.out.println("isInterrupted ? " + Thread.currentThread().isInterrupted());
        System.out.println("After interrupt");
    }
}
