package com.herench.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * com.herench.utils
 *
 * @author zhiwei
 * @create 2017-01-18 22:17.
 */
public class TimeUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_FORMAT = "HH:mm:ss";

    private static SimpleDateFormat dateSdf = new SimpleDateFormat(DATE_FORMAT);

    private static SimpleDateFormat dateTimeSdf = new SimpleDateFormat(DATE_TIME_FORMAT);

    private static SimpleDateFormat timeSdf = new SimpleDateFormat(TIME_FORMAT);

    public static int getRealGap(String dateTime) {
        return getGap(dateTime) - 1;
    }

    public static int getGap(String startTime) {
        Calendar currentCalendar = Calendar.getInstance();
        long currentLong = currentCalendar.getTimeInMillis();
        Date startDate = new Date();
        if (startTime.contains(":")) {
            try {
                startDate = dateTimeSdf.parse(startTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            try {
                startDate = dateSdf.parse(startTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        long startLong = startCalendar.getTimeInMillis();
        return (int) (Math.abs((currentLong - startLong) / (1000 * 3600 * 24)));
    }

    public static long getDelay(String startTime) {
        long startLong = 0L;
        try {
            Date parse = dateTimeSdf.parse(startTime);
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(parse);
            startLong = startCalendar.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar currentCalendar = Calendar.getInstance();
        long currentLong = currentCalendar.getTimeInMillis();
        return (int) (Math.abs(startLong - currentLong));
    }


    public static void main(String[] args) {
//        System.out.println(getRealGap("2016-11-1"));
        System.out.println(getDelay("2017-1-19 13:22:0"));
    }
}
