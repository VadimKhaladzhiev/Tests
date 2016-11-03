package tests.class_loader;

import java.io.IOException;
import java.io.InputStream;

public class PropertiesTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println(c);
        loadProperties();
    }

    private static void loadProperties() {
        java.util.Properties prop = new java.util.Properties();
        InputStream input = null;

        try {

            String filename = "config.properties";
            input = PropertiesTest.class.getClassLoader().getResourceAsStream(filename);
            if(input==null){
                System.out.println("Sorry, unable to find " + filename);
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            System.out.println(prop.getProperty("database"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
