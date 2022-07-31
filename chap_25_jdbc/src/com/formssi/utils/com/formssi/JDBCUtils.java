package com.formssi.utils.com.formssi;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类,完成mysql的连接和关闭资源
 * @author Yang XinHua
 * @date 2022/4/21
 */
public class JDBCUtils {

    //定义相关属性,因为只要一份,因此,我们做出static
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    //在static中代码块去初始化
    static {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("src/jdbc.properties"));
            user = p.getProperty("username");
            password = p.getProperty("password");
            url = p.getProperty("url");
            driver=p.getProperty("driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            //在实际开发中,我们可以这样处理
            //1,将编译异常转换成 运行时异常
            //2,调用者可以选择捕获该异常,也可以选择默认处理该异常,比较方便
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
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
