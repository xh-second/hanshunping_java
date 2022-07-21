package com.formssi.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Yang XinHua
 * @date 2022/4/24
 */
public class C3P0_ {
    //1,方式一,相关参数,在程序中指定user,url,password等

    @Test
    public void testC3P0_01() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("1234");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3307/hsp_mysql");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        //473
        System.out.println("使用數據庫鏈接池，測試鏈接5000次，耗時：" + (System.currentTimeMillis()-start));
    }

    //2,方式二,使用配置文件配置数据库连接池
    @Test
    public void testC3P0_02() throws SQLException {
        System.out.println(ClassLoader.getSystemResource(""));
        ComboPooledDataSource dataSource = new ComboPooledDataSource("hsp_edu");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        //339
        System.out.println("使用數據庫鏈接池，測試鏈接5000次，耗時：" + (System.currentTimeMillis()-start));
    }
}
