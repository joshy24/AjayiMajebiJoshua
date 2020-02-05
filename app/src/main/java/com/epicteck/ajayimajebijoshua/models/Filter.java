package com.epicteck.ajayimajebijoshua.models;

import java.util.List;

public class Filter {
    private int id;
    private int start_year;
    private int end_year;
    private String gender;
    private List<String> countries;
    private List<String> colors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart_year() {
        return start_year;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public int getEnd_year() {
        return end_year;
    }

    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }
}
