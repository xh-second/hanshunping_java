package com.formssi.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Yang XinHua
 * @date 2022/7/30
 */
public class Result_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties p = new Properties();
        p.load(new FileInputStream("chap_25_jdbc/src/jdbc.properties"));
        Class.forName(p.getProperty("driver"));
        Connection conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
        System.out.println(conn);
        String sql = "select id,name,sex,borndate from actor";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String sex = rs.getString(3);
            Date borndate = rs.getDate(4);
            System.out.println(id+"\t"+name+"\t"+sex+"\t"+borndate);
        }
    }
}
