package com.formssi.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC第一个程序
 *
 * @author Yang XinHua
 * @date 2022/7/30
 */
public class Jdbc01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties p = new Properties();
        p.load(new FileInputStream("chap_25_jdbc/src/jdbc.properties"));
        //从Mysql 驱动5.1.6以后开始servers 里面有注册可以不用写
        //Class.forName(p.getProperty("driver"));
        Connection connection = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
//        System.out.println(connection);
//        String sql = "insert into actor values(null,'刘德华','男','1970-11-11','110')";
        String sql = "insert into actor values(null,'jack','男','1990-11-11','110')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
    }
}
