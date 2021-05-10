package kelimetris.core.lib.utility.methods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityMethods {
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public static long dateToInteger(String date) {
        return Integer.valueOf(date);
    }

    public static long getCurrentDate() {
        return Long.parseLong(dateFormat.format(new Date()));
    }

    public static long getLastUpdated() {
        return System.currentTimeMillis();
    }

    public static String getCurrentTime() { return timeFormat.format(new Date()); }
}

