package cn.com.zhirun.crm.servlet;

import cn.com.zhirun.crm.modle.Business;
import cn.com.zhirun.crm.service.BnsService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectBnsByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bnsId = req.getParameter("bnsId");
        BnsService bs = new BnsService();
        Business business = bs.selectBnsById(bnsId);
        Gson gson = new Gson();
        String json = gson.toJson(business);
        resp.getWriter().write(json);
    }
}
