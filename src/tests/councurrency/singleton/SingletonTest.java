package tests.councurrency.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println(Singleton.a);
//        Singleton singleton = Singleton.INSTANCE;
//        singleton.print();
        System.out.println(OndemandSingleton.a);
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        OndemandSingleton ondemandSingleton = OndemandSingleton.getInstance();
//        ondemandSingleton.print();
    }
}
