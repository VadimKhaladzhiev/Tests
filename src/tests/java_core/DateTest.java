package tests.java_core;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Khaladzhiev on 02.03.2017.
 */
public class DateTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal.set(Calendar.MILLISECOND,0);
        cal2.set(Calendar.MILLISECOND,0);

        Date date = cal.getTime();
        Date date2 = cal2.getTime();
        System.out.println(date.toString()+" "+date2.toString()+" "+date2.equals(date));

    }
}
