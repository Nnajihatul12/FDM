package com.example.fdm.Model;

import java.io.Serializable;

public class FormMonetaryAidsEntity implements Serializable {

    public String houseCleaning;
    public String powerbank;
    public String foodWater;
    public String infrastructure;
    public String cash;
    public String electrical;

    public String gethouseCleaning() {
        return houseCleaning;
    }

    public void sethouseCleaning(String houseCleaning) {
        this.houseCleaning = houseCleaning;
    }

    public String getpowerbank() {
        return powerbank;
    }

    public void setpowerbank(String powerbank) {
        this.powerbank = powerbank;
    }

    public String getfoodWater() {
        return foodWater;
    }

    public void setfoodWater(String foodWater) {
        this.foodWater = foodWater;
    }

    public String getinfrastructure() {
        return infrastructure;
    }

    public void setinfrastructure(String infrastructure) {
        this.infrastructure = infrastructure;
    }

    public String getcash() {
        return cash;
    }

    public void setcash(String cash) {
        this.cash = cash;
    }

    public String getelectrical() {
        return electrical;
    }

    public void setelectrical(String electrical) {
        this.electrical = electrical;
    }
}
