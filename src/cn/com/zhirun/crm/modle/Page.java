package cn.com.zhirun.crm.modle;

import java.sql.ResultSet;
import java.util.List;

public class Page {
    private int pages;
    private int nowPage;
    private int num = 0;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }


}
