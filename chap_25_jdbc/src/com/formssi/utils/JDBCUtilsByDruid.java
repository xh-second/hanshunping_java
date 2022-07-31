package com.formssi.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid JDBC 工具类
 * @Author Hua Xin
 * @Date 2022/07/31
 */
public class JDBCUtilsByDruid {

    private static DataSource dataSource;

    //在static中代码块去初始化
    static {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("src/jdbc.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(p);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs, Statement statement,Connection connection){

        //判断是否为null
        try {
            if (rs != null){
                rs.close();
            }
            if (statement != null ) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
