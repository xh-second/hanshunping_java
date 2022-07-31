package com.formssi.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Hua Xin
 * @date 2022/7/31
 */
public class Druid_ {

    @Test
    public void testDruid() throws Exception {
        //1,加入Druid jar包
        //2,加入配置文件 druid.properties,将该文件拷贝到项目的src目录下
        //3,创建Properties 对象,读取配置文件
        Properties p = new Properties();
        p.load(new FileInputStream("src/druid.properties"));
        //4创建一个指定参数的数据库连接池,Druid 连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(p);
        long start = System.currentTimeMillis();
        for (int i = 0;i < 500000;i++){
            Connection connection = dataSource.getConnection();
            //System.out.println(connection.getClass());
            //System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        //druid 连接池 操作 500000 耗时 = 560
        System.out.println("druid 连接池 操作 500000 耗时 = " + (end - start));
    }
}
