package tests.councurrency;

public class DoubleCheckTest {

    private Resource r;
    int i;

    private void run() {
        new Thread((Runnable) new Runnable() {
            @Override
            public void run() {
                DoubleCheckTest.this.r = Resource.getInstance();
            }
        }).start();
        new Thread((Runnable) new Runnable() {
            @Override
            public void run() {
                if (r != null) {
                    assert r.getA() == 1000 : "не 2 ";
                } else {
                    i++;
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        DoubleCheckTest test = new DoubleCheckTest();
        for (int i = 0; i < 10000; i++) {
            test.run();
        }
        System.out.println(test.i);
    }
}

class Resource {

    private int a = 1;

    private static Resource instance;

    private Resource() {
        for (int i = 0; i < 1001 ; i++) {
            a=i;
        }
    }

    static Resource getInstance() {
        if(instance == null)
            synchronized (Resource.class){
                if(instance == null)
                    instance = new Resource();
            }
        return instance;
    }

    public int getA() {
        return a;
    }
}
