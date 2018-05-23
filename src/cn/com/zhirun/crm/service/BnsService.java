package cn.com.zhirun.crm.service;

import cn.com.zhirun.crm.dao.BusinessDao;
import cn.com.zhirun.crm.modle.Business;
import cn.com.zhirun.crm.modle.Page;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BnsService {
    public String createBnsId(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowDate = sdf.format(new Date());
        String bnsId = "LYJ"+nowDate;
        return bnsId;
    }

    public int checkBnsByName(Business business){
        int num = new BusinessDao().checkBnsByName(business);
        return num;
    }
    public Business selectBnsById(String bnsId){
        Business business = new BusinessDao().selectBnsById(bnsId);
        return business;
    }
    public void insertBns(Business business){
        BusinessDao bd = new BusinessDao();
        bd.insertBns(business);
    }
    public List<Business> selectBns(Business business,Page page){
        List<Business> bList = new ArrayList<>();
        BusinessDao bd = new BusinessDao();
        bList= bd.selectBns(business,page);
        return bList;
    }
    public void deleteBns(String bnsId){
        BusinessDao bd = new BusinessDao();
        bd.deleteBns(bnsId);
    }
    public int updateBns(Business business){
        int num = new BusinessDao().updateBns(business);
        return num;
    }
//    public List<Business> selectResultSet(Page page){
//        BusinessDao bd = new BusinessDao();
//        List<Business> bList = bd.selectResultSet(page);
//        return bList;
//    }
}
