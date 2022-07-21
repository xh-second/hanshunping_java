package com.hspedu.date_;

import java.util.Date;
import java.time.Instant;

/**
 *
 * 测试Instant时间戳
 * @author Yang XinHua
 * @date 2022/7/21
 */
public class Instant_ {
    public static void main(String[] args) {
        //1,通过静态方法 now 获取表示当前时间的时间戳
        Instant now = Instant.now();
        System.out.println(now);
        //2,通过from 可以把时间戳Instant转换成Date
        Date date = Date.from(now);
        System.out.println(date);
        Instant instant = date.toInstant();
        System.out.println(instant);
    }
}
