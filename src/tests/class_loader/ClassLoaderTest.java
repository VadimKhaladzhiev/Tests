package tests.class_loader;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class ClassLoaderTest{


    public static void main(String[] args) {

        try {
            String path = "C:\\tomcat-economics\\lib";
            ClassLoader cl = new JarSeekingURLClassLoader(new File(path));
//            setSystemClassLoader(cl);
//            start1(cl);
            start2(cl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setSystemClassLoader(ClassLoader cl) throws NoSuchFieldException, IllegalAccessException {
        Field scl = ClassLoader.class.getDeclaredField("scl"); // Get system class loader
        scl.setAccessible(true); // Set accessible
        scl.set(null, cl);
    }

    private static void start2(ClassLoader cl) {
        try {
            Class clt = Class.forName("tests.class_loader.Task", true, cl);
            Thread thread = new Thread((Runnable)clt.newInstance());
            thread.setContextClassLoader(cl);
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void start1(ClassLoader cl) {
        try {

            Class claszz = Class.forName("org.apache.catalina.util.Base64", false, cl);
            for (Method m : claszz.getMethods()) {
                System.out.println(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        try {
            Thread.currentThread().sleep(6000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
