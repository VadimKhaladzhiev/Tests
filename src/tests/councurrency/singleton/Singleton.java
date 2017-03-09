package tests.councurrency.singleton;

public class Singleton {
    public static int a = 1;
    {
        System.out.println("Singleton: static");
    }
    private Singleton(){
        System.out.println("Singleton: loading");
    }
    public void print(){
        System.out.println("Singleton: ok");
    }
    public static final Singleton INSTANCE = new Singleton();
}
