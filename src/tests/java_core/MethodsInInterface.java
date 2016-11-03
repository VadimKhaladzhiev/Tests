package tests.java_core;

public class MethodsInInterface implements A, B{
    public static void main(String[] args) {
        System.out.println(A.getA());
    }
    public int getB(){
        return 23;
    }
}

interface A{
    default int getC(){return 31;}
    static int getA(){
        return 11;
    }
    default int getB(){
        return getC();
    }
}
interface B{
    static int getA(){
        return 12;
    }
    default int getB(){
        return 22;
    }
}
