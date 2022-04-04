package com.rakib.covid19bd.model;

public class Divisionmodel {
    private String date;
    private String district;
    private String division;
    private String iedcr_confirmed;

    public Divisionmodel(String date, String district, String division, String iedcr_confirmed) {
        this.date = date;
        this.district = district;
        this.division = division;
        this.iedcr_confirmed = iedcr_confirmed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getIedcr_confirmed() {
        return iedcr_confirmed;
    }

    public void setIedcr_confirmed(String iedcr_confirmed) {
        this.iedcr_confirmed = iedcr_confirmed;
    }
}
