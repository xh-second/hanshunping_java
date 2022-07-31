package com.formssi.jdbc.transaction;

import com.formssi.utils.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * 演示转账问题
 * @author Yang XinHua
 * @date 2022/7/30
 */
@SuppressWarnings("all")
public class Transaction_ {
    public static void main(String[] args) throws IOException, SQLException {

    }


    @Test
    public void useTransaction(){
        Connection conn = null;
        String sql = "update account set balance = balance -100 where id = 1";
        String sql2 = "update account set balance = balance +100 where id = 2";
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);//开启事务
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            int i = 1/0;
            ps = conn.prepareStatement(sql2);
            ps.executeUpdate();
            conn.commit();//提交事务
        }catch (Exception e){
            System.out.println("发生异常,需要回滚");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null, ps,conn );
        }
    }

}
