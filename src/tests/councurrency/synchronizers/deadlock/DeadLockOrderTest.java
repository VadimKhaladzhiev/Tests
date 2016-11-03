package tests.councurrency.synchronizers.deadlock;

/**
 * Дедлок получается при зеркальном порядке блокировки объектов
 * Первый поток блокируется по lock1, lock2 -> второй по lock2, lock1
 */
public class DeadLockOrderTest implements Runnable {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    void ltr(){
        try {
            synchronized (lock1){
                Thread.sleep(100);
                synchronized (lock2){
                    Thread.sleep(100);
                    System.out.println("ltr ended");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void rtl(){
        try {
            synchronized (lock2){
                Thread.sleep(100);
                synchronized (lock1){
                    Thread.sleep(100);
                    System.out.println("rtl ended");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){}

    public static void main(String[] args) {
        new Thread(new DeadLockOrderTest() {
            @Override
            public void run() {
                ltr();
            }
        }).start();
        new Thread(new DeadLockOrderTest() {
            @Override
            public void run() {
                rtl();
            }
        }).start();
    }

}
