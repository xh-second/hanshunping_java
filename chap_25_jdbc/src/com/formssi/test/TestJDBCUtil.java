package com.formssi.test;

import com.formssi.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Yang XinHua
 * @date 2022/4/21
 */
public class TestJDBCUtil {

    @Test
    public void testSelect(){

        //1,得到一个连接
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        //2,组织sql
        String sql = "select * from actor where id = ?";
        //3,创建PrepareStatment

        try {
            connection = JDBCUtils.getConnection();
            statement  = connection.prepareStatement(sql);
            statement.setString(1, "1");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                String birthday = resultSet.getString(4);
                String phone = resultSet.getString(5);
                System.out.println(id + "," + name + "," + sex + "," + birthday + "," + phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCUtils.close(resultSet,statement,connection);
    }
}
