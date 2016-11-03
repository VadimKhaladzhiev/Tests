package tests.java_core;

public class ExceptionTests {
    public static void main(String[] args) {
//        finallyAndReturn();

        systemOutAndErrorTest();
    }

    /**
     * Finally выполняется всегда,
     * кроме System.exit(1), крушения JVM (например OutOfMemoryException),
     * если поток-демон
     * */
    private static void finallyAndReturn() {
        try{
            System.out.println("Try");
            System.exit(1);
//            return;
            throw new Error("exception");
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
        finally {
            System.out.println("Finally");
        }
    }

    private static void systemOutAndErrorTest() {
        System.out.println("sout");
        throw new Error();
    }
}
