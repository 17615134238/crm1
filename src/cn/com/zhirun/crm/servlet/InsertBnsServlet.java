package cn.com.zhirun.crm.servlet;

import cn.com.zhirun.crm.modle.Business;
import cn.com.zhirun.crm.service.BnsService;
import cn.com.zhirun.crm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertBnsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BnsService bs = new BnsService();
        Business business = new Business();
        String bnsId = bs.createBnsId();
        String bnsName = req.getParameter("bnsName");
        String bnsTel = req.getParameter("bnsTel");
        String bnsGroup = req.getParameter("bnsGroup");
        String bnsArea = req.getParameter("bnsArea");
        String bnsAddr = req.getParameter("bnsAddr");
        String bnsMoney = req.getParameter("bnsMoney");
        business.setBns_id(bnsId);
        business.setBns_name(bnsName);
        business.setBns_tel(bnsTel);
        business.setBns_group(bnsGroup);
        business.setBns_area(bnsArea);
        business.setBns_addr(bnsAddr);
        business.setBns_money(Double.parseDouble(bnsMoney));
        business.setBns_create_date(new UserService().getNowDate());
        business.setBns_update_date(new UserService().getNowDate());
        int num = bs.checkBnsByName(business);
        if(num==0){
            bs.insertBns(business);
            resp.sendRedirect("/crm/jsp/chaxun.jsp");
        }
    }
}
