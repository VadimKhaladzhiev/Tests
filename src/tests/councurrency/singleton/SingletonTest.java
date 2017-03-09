package tests.councurrency.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println(Singleton.a);
//        Singleton singleton = Singleton.INSTANCE;
//        singleton.print();
        System.out.println(OndemandSingleton.a);
//        OndemandSingleton ondemandSingleton = OndemandSingleton.getInstance();
//        ondemandSingleton.print();
    }
}
