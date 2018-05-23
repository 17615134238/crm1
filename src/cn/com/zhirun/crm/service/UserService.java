package cn.com.zhirun.crm.service;

import cn.com.zhirun.crm.dao.UserDao;
import cn.com.zhirun.crm.modle.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserService {

    public String  createUserId(){
        String userId = "000001";
        UserDao ud = new UserDao();
        List<String> sList = ud.selectUser();
        if(sList==null||sList.isEmpty()){
            return userId;
        }else {
            int id = Integer.valueOf(sList.get(sList.size()-1))+1;
            userId = checkId(String.valueOf(id));
            return userId;
        }
    }

    private String checkId(String id){
        if(id.length()==1){
            id = "00000"+id;
        }
        else if(id.length()==2){
            id = "0000"+id;
        }
        else if(id.length()==3){
            id = "000"+id;
        }
        else if(id.length()==4){
            id = "00"+id;
        }
        else{
            id = "0"+id;
        }


        return id;
    }

    public int checkUserExistByName(User user){
        int num = 0;
        UserDao ud = new UserDao();
        num = ud.checkUserExistByName(user);
        return num;
    }

    public void insertUser(User user){
        UserDao ud = new UserDao();
        ud.insertUser(user);
    }

    public String getNowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
       String nowDate = sdf.format(new Date());
       return nowDate;
    }

    public int checkUser(User user){
        int num = new UserDao().checkUser(user);
        return  num;
    }


}
