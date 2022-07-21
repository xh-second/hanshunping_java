package com.hspedu.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 第一代日期类:Date
 * @author Yang XinHua
 * @date 2022/7/21
 */
public class Date01 {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();//获取当前时间
        System.out.println("当前时间是: " + d1);
        //通过指定的毫秒数获取时间
        Date d2 = new Date(9234567);
        System.out.println("当前时间是: " + d2);
        //SimplateDateFormat可以格式化日期,也可以将字符串转换成日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String s =  "1996年01月01日 10:20:30 星期一";
        Date d3 = sdf.parse(s);
        System.out.println(d3);

    }
}
