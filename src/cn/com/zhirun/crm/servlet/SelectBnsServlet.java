package cn.com.zhirun.crm.servlet;

import cn.com.zhirun.crm.modle.Business;
import cn.com.zhirun.crm.modle.Page;
import cn.com.zhirun.crm.service.BnsService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectBnsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");
        String rowNum = req.getParameter("rowNum");
        Page page = new Page();
        String pages = req.getParameter("pages");
        String nowPage = req.getParameter("nowPage");
        BnsService bs = new BnsService();
        if(null!=num&&!"".equals(num)) {
            String bnsId = req.getParameter("bnsId");
            String bnsName = req.getParameter("bnsName");
            String bnsTel = req.getParameter("bnsTel");
            String bnsGroup = req.getParameter("bnsGroup");
            String bnsArea = req.getParameter("bnsArea");
            String bnsAddr = req.getParameter("bnsAddr");
            String bnsMoneyFrom = req.getParameter("bnsMoneyFrom");
            String bnsMoneyTo = req.getParameter("bnsMoneyTo");
            Business business = new Business();
            business.setBns_id(bnsId);
            business.setBns_name(bnsName);
            business.setBns_tel(bnsTel);
            business.setBns_group(bnsGroup);
            business.setBns_area(bnsArea);
            business.setBns_addr(bnsAddr);
            business.setRowNum(Integer.parseInt(rowNum));
            if(bnsMoneyFrom!=null&&!"".equals(bnsMoneyFrom)) {
                business.setBns_moneyFrom(Double.valueOf(bnsMoneyFrom));
            }
            if(bnsMoneyTo!=null&&!"".equals(bnsMoneyTo)){
                business.setBns_moneyTo(Double.valueOf(bnsMoneyTo));
            }

            req.getSession().setAttribute("business",business);
            page.setNum(Integer.valueOf(num));
            page.setNowPage(1);
        }
        else {
            if(null!=pages&&!"".equals(pages)) {
                page.setPages(Integer.parseInt(pages));
            }
            if(null!=nowPage&&!"".equals(nowPage)) {
                page.setNowPage(Integer.parseInt(nowPage));
            }
        }
        Business business = (Business) req.getSession().getAttribute("business");
        List<Business> bList = new ArrayList<>();
        if(business!=null){
           bList = bs.selectBns(business,page);
        }
        Gson gson = new Gson();
        String json = gson.toJson(bList);
        resp.getWriter().write(json);



    }
}
