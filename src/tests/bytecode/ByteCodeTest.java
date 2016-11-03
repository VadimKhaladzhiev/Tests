package tests.bytecode;

public class ByteCodeTest {
    public static void main(String []args){
        try {
            tryM();
            System.out.println("afterTry");
            return;
        } catch (Exception e) {
            catchM();
        }
        finally {
            finM();
            finM();
        }
        System.out.println("the end");
    }
    private static void tryM() throws Exception{
        System.out.println("try");
        throw new Exception("exception");
    }
    private static void catchM(){
        System.out.println("catch");
    }
    private static void finM(){
        System.out.println("fin");
    }
}
