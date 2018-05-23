package cn.com.zhirun.crm.servlet;

import cn.com.zhirun.crm.modle.User;
import cn.com.zhirun.crm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        User user = new User();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        UserService us = new UserService();
        int num = us.checkUser(user);
        if(num>0){
            req.getSession().setAttribute("userName",userName);

        }
        resp.getWriter().write(String.valueOf(num));
    }
}
