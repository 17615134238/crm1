package cn.com.zhirun.crm.dao;

import cn.com.zhirun.crm.modle.Business;
import cn.com.zhirun.crm.modle.Page;
import cn.com.zhirun.crm.service.UserService;
import cn.com.zhirun.crm.util.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessDao {
    public int checkBnsByName(Business business){
    int num = 0;
    try {
        Connection conn = DBConnection.getConnection();
        String sql = "select count(bns_name) count from t_business where bns_name=? limit 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,business.getBns_name());
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
    public Business selectBnsById(String bnsId){
    Business business = new Business();
    try {
        Connection conn = DBConnection.getConnection();
        String sql = "select bns_name,bns_tel,bns_group,bns_area,bns_addr,bns_money from t_business where bns_id=? limit 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,bnsId);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            business.setBns_name(rs.getString("bns_name"));
            business.setBns_tel(rs.getString("bns_tel"));
            business.setBns_group(rs.getString("bns_group"));
            business.setBns_area(rs.getString("bns_area"));
            business.setBns_addr(rs.getString("bns_addr"));
            business.setBns_money(rs.getDouble("bns_money"));
        }
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return business;
}
    public void insertBns(Business business){
        Connection conn = null;
        try {
             conn = DBConnection.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into t_business(bns_id,bns_name,bns_tel,bns_group,bns_area,bns_addr,bns_money,bns_create_date,bns_update_date,bns_deleflg) " +
                    " values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,business.getBns_id());
            ps.setString(2,business.getBns_name());
            ps.setString(3,business.getBns_tel());
            ps.setString(4,business.getBns_group());
            ps.setString(5,business.getBns_area());
            ps.setString(6,business.getBns_addr());
            ps.setDouble(7,business.getBns_money());
            ps.setString(8,business.getBns_create_date());
            ps.setString(9,business.getBns_update_date());
            ps.setInt(10,0);
            ps.executeUpdate();
            conn.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }
    public int updateBns(Business business){
        Connection conn = null;
        int num = 0;
        try {
             conn = DBConnection.getConnection();
            conn.setAutoCommit(false);
            String sql = "update t_business set bns_name=?,bns_tel=?,bns_group=?,bns_area=?,bns_addr=?,bns_money=?,bns_update_date=? " +
                    " where bns_id=? and (bns_name!=? or bns_tel!=? or bns_group!=? or bns_area!=? or bns_addr!=? or bns_money!=?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,business.getBns_name());
            ps.setString(2,business.getBns_tel());
            ps.setString(3,business.getBns_group());
            ps.setString(4,business.getBns_area());
            ps.setString(5,business.getBns_addr());
            ps.setDouble(6,business.getBns_money());
            ps.setString(7,business.getBns_update_date());
            ps.setString(8,business.getBns_id());
            ps.setString(9,business.getBns_name().trim());
            ps.setString(10,business.getBns_tel().trim());
            ps.setString(11,business.getBns_group().trim());
            ps.setString(12,business.getBns_area().trim());
            ps.setString(13,business.getBns_addr().trim());
            ps.setDouble(14,business.getBns_money());
            num = ps.executeUpdate();
            conn.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return num;

    }
    public List<Business> selectBns(Business business,Page page){
        List<Business> bList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement sta = conn.createStatement();
            String sql = " select bns_id,bns_name,bns_tel,bns_group,bns_area,bns_addr,bns_money" +
                    " from t_business where bns_deleflg=0";
            if(business.getBns_id()!=null&&!"".equals(business.getBns_id())){
                sql = sql+" and bns_id like '%"+business.getBns_id()+"%'";
            }
            if(business.getBns_name()!=null&&!"".equals(business.getBns_name())){
                sql = sql+" and bns_name like '%"+business.getBns_name()+"%'";
            }
            if(business.getBns_tel()!=null&&!"".equals(business.getBns_tel())){
                sql = sql+"and bns_tel='"+business.getBns_tel()+"'";
            }
            if(business.getBns_group()!=null&&!"".equals(business.getBns_group())){
                sql = sql+" and bns_group='"+business.getBns_group()+"'";
            }
            if(business.getBns_area()!=null&&!"".equals(business.getBns_area())){
                sql = sql+" and bns_area='"+business.getBns_area()+"'";
            }
            if(business.getBns_addr()!=null&&!"".equals(business.getBns_addr())){
                sql = sql+" and bns_addr like '%"+business.getBns_addr()+"%'";
            }
            sql = sql+" and bns_money>="+ business.getBns_moneyFrom();
            if(business.getBns_moneyTo()!=-1.0){
                sql = sql + " and bns_money<=" + business.getBns_moneyTo();
            }
            if(page.getNum()==0) {
                sql = sql + " limit " + (page.getNowPage() - 1) * business.getRowNum() + ","+business.getRowNum()+" ";
            }
             ResultSet rs = sta.executeQuery(sql);
            while (rs.next()){
                Business bus = new Business();
                bus.setBns_id(rs.getString("bns_id"));
                bus.setBns_name(rs.getString("bns_name"));
                bus.setBns_tel(rs.getString("bns_tel"));
                bus.setBns_group(rs.getString("bns_group"));
                bus.setBns_area(rs.getString("bns_area"));
                bus.setBns_addr(rs.getString("bns_addr"));
                bus.setBns_money(rs.getDouble("bns_money"));
                bList.add(bus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bList;
    }
    public void deleteBns(String bnsId){
        {
            Connection conn = null;
            try {
                conn = DBConnection.getConnection();
                conn.setAutoCommit(false);
                String sql = "update t_business set bns_deleflg=1,bns_update_date=? where bns_id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,new UserService().getNowDate());
                    ps.setString(2,bnsId);
                    ps.executeUpdate();


                conn.commit();

            } catch (IOException e) {
                e.printStackTrace();
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }

        }
    }

//    public List<Business> selectResultSet(Page page){
//        List<Business> bList = new ArrayList<>();
//        try {
//            Connection conn = DBConnection.getConnection();
//            String sql = " select bns_id,bns_name,bns_tel,bns_group,bns_area,bns_addr,bns_money " +
//                    " from "+page.getRs()+" limit "+page.getNowPage()*5+" 5";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                Business bus = new Business();
//                bus.setBns_id(rs.getString("bns_id"));
//                bus.setBns_name(rs.getString("bns_name"));
//                bus.setBns_tel(rs.getString("bns_tel"));
//                bus.setBns_group(rs.getString("bns_group"));
//                bus.setBns_area(rs.getString("bns_area"));
//                bus.setBns_addr(rs.getString("bns_addr"));
//                bus.setBns_money(rs.getDouble("bns_money"));
//                bList.add(bus);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return bList;
//    }
}
