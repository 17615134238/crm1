package cn.com.zhirun.crm.servlet;

import cn.com.zhirun.crm.modle.Business;
import cn.com.zhirun.crm.service.BnsService;
import cn.com.zhirun.crm.service.UserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateBnsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bnsId = req.getParameter("bnsId");
        String bnsName = req.getParameter("bnsName");
        String bnsTel = req.getParameter("bnsTel");
        String bnsGroup = req.getParameter("bnsGroup");
        String bnsArea = req.getParameter("bnsArea");
        String bnsAddr = req.getParameter("bnsAddr");
        String bnsMoney = req.getParameter("bnsMoney");
        Business business = new Business();
        business.setBns_id(bnsId);
        business.setBns_name(bnsName);
        business.setBns_tel(bnsTel);
        business.setBns_group(bnsGroup);
        business.setBns_area(bnsArea);
        business.setBns_addr(bnsAddr);
        business.setBns_money(Double.parseDouble(bnsMoney));
        business.setBns_update_date(new UserService().getNowDate());
        BnsService bs = new BnsService();
       int num = bs.updateBns(business);
       if(num!=0){
           req.getSession().setAttribute("business1",business);
       }
        resp.getWriter().write(String.valueOf(num));
    }
}
