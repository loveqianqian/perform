package com.herench;

import com.herench.utils.TimeUtils;

import java.util.Calendar;

/**
 * com.herench
 *
 * @author zhiwei
 * @create 2017-05-03 14:21.
 * @github {@https://github.com/loveqianqian}
 */
public class MonthTest {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        int monthPre = calendar.get(Calendar.MONTH);
        System.out.println(monthPre);

        System.out.println(TimeUtils.getRealGap("2017-4-30"));

        calendar.set(Calendar.MONTH, monthPre-1);
        System.out.println(calendar.getActualMaximum(Calendar.DATE)+2);
    }
}
