package com.hspedu.date_;

import java.util.Calendar;

/**
 * 第二代日期类
 * @author Yang XinHua
 * @date 2022/7/21
 */
public class Calendar_ {

    public static void main(String[] args) {
        //创建日期类对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("当前年份: " + calendar.get(Calendar.YEAR));
        System.out.println("当前月份: " + (calendar.get(Calendar.MONTH)+1));
        System.out.println("当前日期: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("当前时: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("当前分: " + calendar.get(Calendar.MINUTE));
        System.out.println("当前秒: " + calendar.get(Calendar.SECOND));
        System.out.println("当前星期: " + calendar.get(Calendar.DAY_OF_WEEK));
    }

}
