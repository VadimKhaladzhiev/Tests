package tests.bytecode;

import java.util.Objects;

/**
 * Created by Khaladzhiev on 17.10.2016.
 */
public class HashCodeTest {
    public static void main(String[] args) {
        if(true){
            int r;
            System.out.println();
        }
        System.out.println( Objects.hash("someisbn", new Integer(109), new Integer(434)));
        System.out.println( Objects.hash("someisbn", new Integer(110), new Integer(403)));
        String a = null;
        String b = "www";
        System.out.println();
    }
}
