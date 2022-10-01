package com.example.fdm.Model;

import java.io.Serializable;

public class FormGroceryAidsEntity implements Serializable {

    public String hygienes;
    public String cleaningAppliances;
    public String food;
    public String medic;
    public String clothes;


    public String gethygienes() {
        return hygienes;
    }

    public void sethygienes(String hygienes) {
        this.hygienes = hygienes;
    }

    public String getcleaningAppliances() {
        return cleaningAppliances;
    }

    public void setcleaningAppliances(String cleaningAppliances) {
        this.cleaningAppliances = cleaningAppliances;
    }

    public String getfood() {
        return food;
    }

    public void setfood(String food) {
        this.food = food;
    }

    public String getmedic() {
        return medic;
    }

    public void setmedic(String medic) {
        this.medic = medic;
    }

    public String getclothes() {
        return clothes;
    }

    public void setclothes(String clothes) {
        this.clothes = clothes;
    }

}


