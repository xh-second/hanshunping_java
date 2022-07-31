package com.formssi.jdbc.datasource;

import com.formssi.entity.Actor;
import com.formssi.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hua Xin
 * @date 2022/7/31
 */
@SuppressWarnings("all")
public class JDBCUtilsByDruid_USE {


    @Test
    public void testSelect(){
        System.out.println("使用druid方式完成:");
        //1,得到连接
        Connection conn = null;
        //2,组织一个sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            System.out.println(conn.getClass());
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            set = preparedStatement.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtilsByDruid.close(set, preparedStatement, conn);
        }
    }

    public List<Actor> getSelectArrayList(){
        System.out.println("使用druid方式完成:");
        //1,得到连接
        Connection conn = null;
        //2,组织一个sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        List<Actor> list = new ArrayList<>();
        try {
            conn = JDBCUtilsByDruid.getConnection();
            System.out.println(conn.getClass());
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            set = preparedStatement.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                list.add(new Actor(id, name, sex, borndate, phone));
                //System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtilsByDruid.close(set, preparedStatement, conn);
        }
        System.out.println(list);
        return list;
    }

    @Test
    public void testSelectArrayList(){
        getSelectArrayList();
    }


}
