package com.example.sethsahapharmacy;

public class Itemstore {

    private String item_name;
    private int item_price;
    private int item_qty;

    public Itemstore(){}

    public Itemstore(String item_name, int item_price, int item_qty) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_qty = item_qty;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public int getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(int item_qty) {
        this.item_qty = item_qty;
    }
}
