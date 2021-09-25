package com.example.sethsahapharmacy;

import android.widget.EditText;

public class Cardstore {

    private String card_name;
    private int card_number;
    private int expiry;
    private String name;
    private int cvv;

    public Cardstore(){}

    public Cardstore ( String card_name, int card_number, int expiry, String name, int cvv) {
        this.card_name = card_name;
        this.card_number = card_number;
        this.expiry = expiry;
        this.name = name;
        this.cvv = cvv;
    }


    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
