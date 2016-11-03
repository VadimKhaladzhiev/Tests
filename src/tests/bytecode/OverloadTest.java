package tests.bytecode;

public class OverloadTest {
    public static void main(String[] args) {
        new OverloadTest().test((String)null);
    }
    void test(Long a){
        System.out.println("a");
    }
    void test(String b){
        System.out.println("b");
    }
}
