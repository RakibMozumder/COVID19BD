package com.rakib.covid19bd.model;

/*
 * Summary class holds the COVID related information for a province
 */
public class SummaryWorld {
    private String date;
    private int newConfirmed;
    private int newDeaths;
    private int newRecovered;
    private int totalConfirmed;
    private int totalDeaths;
    private int totalRecovered;

    public SummaryWorld(String date, int newConfirmed, int newDeaths, int newRecovered, int totalConfirmed, int totalDeaths, int totalRecovered) {
        this.date = date;
        this.newConfirmed = newConfirmed;
        this.newDeaths = newDeaths;
        this.newRecovered = newRecovered;
        this.totalConfirmed = totalConfirmed;
        this.totalDeaths = totalDeaths;
        this.totalRecovered = totalRecovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        this.newRecovered = newRecovered;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }
}

