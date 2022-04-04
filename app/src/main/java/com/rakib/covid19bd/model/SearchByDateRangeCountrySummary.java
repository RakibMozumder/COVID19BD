package com.rakib.covid19bd.model;

/*
 * Summary class holds the COVID related information for a province
 */
public class SearchByDateRangeCountrySummary {
    private int Confirmed;
    private int Active;
    private int Recovered;
    private int Deaths;




    public int getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(int confirmed) {
        Confirmed = confirmed;
    }

    public int getDeaths() {
        return Deaths;
    }

    public void setDeaths(int deaths) {
        Deaths = deaths;
    }

    public int getRecovered() {
        return Recovered;
    }

    public void setRecovered(int recovered) {
        Recovered = recovered;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int active) {
        Active = active;
    }

    public SearchByDateRangeCountrySummary(int Confirmed , int Deaths, int Recovered, int Active) {

        this.Confirmed = Confirmed;
        this.Deaths= Deaths;
        this.Recovered = Recovered;
        this.Active = Active;

    }



}

