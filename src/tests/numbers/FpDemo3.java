package tests.numbers;

class FpDemo3Parent{
    static int a_st;

    static {
        a_st = 80;
    }

    int a;
    {
        a = 90;
    }
}

public class FpDemo3 extends FpDemo3Parent {
    public static void main(String[] args) {
        double d = 8e+307;
        System.out.println(4.0 * d * 0.5);
        System.out.println(2.0 * d);
    }
}
