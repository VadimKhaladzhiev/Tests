package tests.java_core;


public class StaticAndDynamicLinkTest extends SuperClass{
    public static void main(String[] args) {
        StaticAndDynamicLinkTest test = new StaticAndDynamicLinkTest();
        test.test2(1L);
    }
    public void test2(Long a){
        System.out.println("1");
    }
}

class SuperClass{
    public void test2(Long a){
        System.out.println("2");
    }
}