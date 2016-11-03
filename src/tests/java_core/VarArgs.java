package tests.java_core;

public class VarArgs {
    static void vaTest(int ... v) {
        System.out.print("Количество аргументов: " + v.length + " Содержимое: ");
        for(int x : v)
        System.out.print (x + " ");
        System.out.println ();
    }

    public static void main(String args[]) {
        int п2[] = { 1, 2, 3 };
        vaTest (10);	//1 аргумент
        vaTest (1, 2, 3); //3 аргумента
        vaTest (п2);	// без аргументов
    }
}
