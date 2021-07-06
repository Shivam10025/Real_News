package com.example.realnews;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Articles {
    private String name;
    private String alpha_two_code;
    private String country;

    public Articles(String name, String alpha_two_code, String country) {
        this.name = name;
        this.alpha_two_code = alpha_two_code;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha_two_code() {
        return alpha_two_code;
    }

    public void setAlpha_two_code(String alpha_two_code) {
        this.alpha_two_code = alpha_two_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}