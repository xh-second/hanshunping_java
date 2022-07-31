package com.formssi.test;

import com.formssi.utils.com.formssi.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author Yang XinHua
 * @date 2022/4/24
 * 编写程序完成连接MySql 5000次的操作
 * 看看有什么问题,耗时多久
 */
public class ConQuestion {
    @Test
    public void testCon(){
        long start = System.currentTimeMillis();
        System.out.println("开始连接");
        for (int i = 0; i < 5000; i++) {
            Connection connection = JDBCUtils.getConnection();
            //do something
            //关闭连接
            JDBCUtils.close(null,null,connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式5000次,耗时= " + (end-start));
    }
}
