package tests.com.company;

class Main{

    public static void show(){
        System.out.println("Static method called");
    }
    public static void main(String[] args)  {
        Main obj = new Main();
        obj.show();
    }
}
