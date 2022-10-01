package com.example.fdm.Model;

import java.io.Serializable;

public class FormHealthAidsEntity implements Serializable {

    public String dryfood;
    public String hygienekits;
    public String portablewater;
    public String medicines;
    public String ambulances;
    public String blankets;

    public String getDryfood() {
        return dryfood;
    }

    public void setDryfood(String dryfood) {
        this.dryfood = dryfood;
    }

    public String getHygienekits() {
        return hygienekits;
    }

    public void setHygienekits(String hygienekits) {
        this.hygienekits = hygienekits;
    }

    public String getPortablewater() {
        return portablewater;
    }

    public void setPortablewater(String portablewater) {
        this.portablewater = portablewater;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getAmbulances() {
        return ambulances;
    }

    public void setAmbulances(String ambulances) {
        this.ambulances = ambulances;
    }

    public String getBlankets() {
        return blankets;
    }

    public void setBlankets(String blankets) {
        this.blankets = blankets;
    }
}
