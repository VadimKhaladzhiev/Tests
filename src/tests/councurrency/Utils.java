package tests.councurrency;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static String getFormattedDate(SimpleDateFormat sdf) {
        return sdf.format(new Date());
    }

    public static int getRandomWaitTime() {
        return (int) ((Math.random() + 1) * 1000);
    }

}
