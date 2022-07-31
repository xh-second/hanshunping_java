package com.formssi.jdbc.batch;

import com.formssi.utils.com.formssi.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Yang XinHua
 * @date 2022/7/30
 * 演示java批量处理
 */
public class Batch_ {

    //传统方法添加5000条数据到admin
    @Test
    public void noBatch() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        System.out.println("开始执行: ");
        long start = System.currentTimeMillis();
        for (int i = 0;i < 50000;i++){
            statement.setString(1,"jack" + i);
            statement.setString(2, "666");
            statement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式 耗时= " + (end - start) );
        JDBCUtils.close(null, statement, conn);//传统方式 耗时= 182930
    }


    @Test
    public void batch() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        System.out.println("开始执行~");
        long start = System.currentTimeMillis();
        for (int i = 0;i < 50000; i++){
            statement.setString(1,"jack" + i);
            statement.setString(2, "666");
            statement.addBatch();
            if ((i+1)%10000 == 0 ){
                statement.executeBatch();
                statement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量方式 耗时 = " + (end - start));
        JDBCUtils.close(null, statement, conn);//批量方式 耗时 = 550 ,请留意需要开启:rewriteBatchedStatements=true
    }
}
