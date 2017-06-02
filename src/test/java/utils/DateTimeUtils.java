package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

    public static String addTimeStampPostfix(String value, String dateFormat) {
        SimpleDateFormat sdfDate = new SimpleDateFormat(dateFormat);
        Date now = new Date();
        value = value + sdfDate.format(now);
        return value;
    }
}
