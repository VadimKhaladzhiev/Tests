package tests.strings;

public class ConcatTest {
    public static void main(String[] args) {
        String a = new String("a");
        String b = new String("b");

        String a1 = new String("a1");
        String b1 = new String("b1");

        StringBuilder sb1 = new StringBuilder();
        sb1.append(new String());
        sb1.append(new Integer(1));

        sb1.toString();

        long t3 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(new Integer(1));
        }
        String d = sb.toString();
        long t4 = System.nanoTime();
        System.out.println(t4-t3);

        long t1 = System.nanoTime();
        String c =new String();
//        for (int i = 0; i < 100; i++) {
            c = c+ new Integer(1) + new Integer(1);
//            c += new Integer(1);
//        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);

        String st = a1 + b1;


    }

    private void concatString() {
        long t1 = System.nanoTime();
        String a = new String("a");
//        a = a.concat(new Integer(1));
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
    }

    private void concatStringPlus() {
        String a = new String("a");
        String b = new String("b");
        long t1 = System.nanoTime();
        String c = a+b;
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
    }

    private void concatStringBuilder() {
        String a = new String("a");
        String b = new String("b");
        long t1 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        String c = sb.toString();
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
    }

    private static void bytecodeTest() {
        //        String a = "a".concat("b");
        String a1 = new String("a");
        String b1 = new String("b");
        String a = a1.concat(b1);
    }
}
