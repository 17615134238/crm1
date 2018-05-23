package cn.com.zhirun.crm.dao;

import cn.com.zhirun.crm.modle.User;
import cn.com.zhirun.crm.util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<String> selectUser(){
        Connection conn;
        List<String> sList = null;

            try {
                conn = DBConnection.getConnection();
                String sql = " select user_id id from t_user";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    sList = new ArrayList<>();
                    sList.add(rs.getString("id"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return sList;
    }
   public int checkUserExistByName(User user){
       int num = 0;
       Connection conn;

       {
           try {
               conn = DBConnection.getConnection();
               String sql = " select count(*) count from t_user where user_name=? limit 1";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1,user.getUserName());
               ResultSet rs = ps.executeQuery();
               if(rs.next()){
                   num = rs.getInt("count");
               }
           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return num;
   }
   public void insertUser(User user){
       Connection conn = null;

       {
           try {
               conn = DBConnection.getConnection();
               conn.setAutoCommit(false);
               String sql = " insert into t_user(user_id,user_name,user_pwd,user_create_date)" +
                       " values(?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1,user.getUserId());
               ps.setString(2,user.getUserName());
               ps.setString(3,user.getUserPwd());
               ps.setString(4,user.getUserNow());
               ps.executeUpdate();
               conn.commit();
           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           } catch (SQLException e) {
               e.printStackTrace();
               try {
                   conn.rollback();
               } catch (SQLException e1) {
                   e1.printStackTrace();
               }
           }
       }
   }
   public int checkUser(User user){
        int num = 0;
       try {
           Connection conn = DBConnection.getConnection();
           String sql = " select count(user_id) count from t_user where user_name=? and user_pwd=? limit 1";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1,user.getUserName());
           ps.setString(2,user.getUserPwd());
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               num = rs.getInt("count");
           }
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return num;
   }
}
