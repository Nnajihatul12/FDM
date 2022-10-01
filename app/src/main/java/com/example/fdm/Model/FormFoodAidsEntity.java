package com.example.fdm.Model;

import java.io.Serializable;

public class FormFoodAidsEntity implements Serializable {

    public String rice;
    public String milk;
    public String biscuits;
    public String candles;
    public String diapers;


    public String getrice() {
        return rice;
    }

    public void setrice(String rice) {
        this.rice = rice;
    }

    public String getmilk() {
        return milk;
    }

    public void setmilk(String milk) {
        this.milk = milk;
    }

    public String getbiscuits() {
        return biscuits;
    }

    public void setbiscuits(String biscuits) {
        this.biscuits = biscuits;
    }

    public String getcandles() {
        return candles;
    }

    public void setcandles(String candles) {
        this.candles = candles;
    }

    public String getdiapers() {
        return diapers;
    }

    public void setdiapers(String diapers) {
        this.diapers = diapers;
    }

}

