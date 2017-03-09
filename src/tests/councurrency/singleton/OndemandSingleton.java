package tests.councurrency.singleton;

/**
 * Created by Khaladzhiev on 09.03.2017.
 */
public class OndemandSingleton {
    public static int a = 1;
    {
        System.out.println("OndemandSingleton: static");
    }
    private OndemandSingleton(){
        System.out.println("OndemandSingleton: loading");
    }
    public void print(){
        System.out.println("OndemandSingleton: ok");
    }
    public static class SingletonHolder {
        public static final OndemandSingleton HOLDER_INSTANCE = new OndemandSingleton();
    }

    public static OndemandSingleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
