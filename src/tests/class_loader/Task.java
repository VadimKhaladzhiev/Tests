package tests.class_loader;

import java.lang.reflect.Method;

public class Task implements Runnable{

    public Task(){

    }

    public void run(){
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            Class claszz = Class.forName("org.apache.catalina.util.Base64", false, cl);
            for (Method m : claszz.getMethods()) {
                System.out.println(m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
