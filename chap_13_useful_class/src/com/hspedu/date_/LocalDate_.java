package com.hspedu.date_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 第三代日期类
 * @author Yang XinHua
 * @date 2022/7/21
 */
public class LocalDate_ {
    public static void main(String[] args) {
        //使用now获取当前值
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formateDate = timeFormatter.format(ldt);
        System.out.println(formateDate);
        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());
        System.out.println("==============");
        LocalTime lt = LocalTime.now();
        System.out.println(lt);
        LocalDateTime localDateTime = ldt.plusDays(7);
        System.out.println(timeFormatter.format(localDateTime));

    }
}
