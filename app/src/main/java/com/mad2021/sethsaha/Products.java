package com.mad2021.sethsaha;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.Date;

public class Products implements Serializable {


    @Exclude
    private String key;
    private String ID;
    private String pname;
    private int price;
    private int weight;
    private String edate;
    private String des;

    public Products(){}

    public Products(String ID, String pname, int price, int weight, String edate, String des) {
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

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
