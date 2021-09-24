package com.mad2021.sethsaha;

import java.util.Date;

public class Products {
    private String ID;
    private String pname;
    private int price;
    private int weight;
    private int edate;
    private String des;

    public Products(){}

    public Products(String ID, String pname, int price, int weight, int edate, String des) {
        this.ID = ID;
        this.pname = pname;
        this.price = price;
        this.weight = weight;
        this.edate = edate;
        this.des = des;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getEdate() {
        return edate;
    }

    public void setEdate(int edate) {
        this.edate = edate;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
