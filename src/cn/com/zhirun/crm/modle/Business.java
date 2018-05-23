package cn.com.zhirun.crm.modle;

public class Business {
    private String bns_id;
    private String bns_name;
    private String bns_tel;
    private String bns_group;
    private String bns_area;
    private String bns_addr;
    private Double bns_money;
    private Double bns_moneyFrom = 0.0;
    private Double bns_moneyTo = -1.0;
    private int rowNum;

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public Double getBns_moneyFrom() {
        return bns_moneyFrom;
    }

    public void setBns_moneyFrom(Double bns_moneyFrom) {
        this.bns_moneyFrom = bns_moneyFrom;
    }

    public Double getBns_moneyTo() {
        return bns_moneyTo;
    }

    public void setBns_moneyTo(Double bns_moneyTo) {
        this.bns_moneyTo = bns_moneyTo;
    }

    private String bns_create_date;
    private String bns_update_date;
    private int bns_deleflg;
    private String bns_comment;

    public String getBns_id() {
        return bns_id;
    }

    public void setBns_id(String bns_id) {
        this.bns_id = bns_id;
    }

    public String getBns_name() {
        return bns_name;
    }

    public void setBns_name(String bns_name) {
        this.bns_name = bns_name;
    }

    public String getBns_tel() {
        return bns_tel;
    }

    public void setBns_tel(String bns_tel) {
        this.bns_tel = bns_tel;
    }

    public String getBns_group() {
        return bns_group;
    }

    public void setBns_group(String bns_group) {
        this.bns_group = bns_group;
    }

    public String getBns_area() {
        return bns_area;
    }

    public void setBns_area(String bns_area) {
        this.bns_area = bns_area;
    }

    public String getBns_addr() {
        return bns_addr;
    }

    public void setBns_addr(String bns_addr) {
        this.bns_addr = bns_addr;
    }

    public Double getBns_money() {
        return bns_money;
    }

    public void setBns_money(Double bns_money) {
        this.bns_money = bns_money;
    }

    public String getBns_create_date() {
        return bns_create_date;
    }

    public void setBns_create_date(String bns_create_date) {
        this.bns_create_date = bns_create_date;
    }

    public String getBns_update_date() {
        return bns_update_date;
    }

    public void setBns_update_date(String bns_update_date) {
        this.bns_update_date = bns_update_date;
    }

    public int getBns_deleflg() {
        return bns_deleflg;
    }

    public void setBns_deleflg(int bns_deleflg) {
        this.bns_deleflg = bns_deleflg;
    }

    public String getBns_comment() {
        return bns_comment;
    }

    public void setBns_comment(String bns_comment) {
        this.bns_comment = bns_comment;
    }
}
