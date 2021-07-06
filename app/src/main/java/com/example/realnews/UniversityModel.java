package com.example.realnews;

import java.util.ArrayList;

public class UniversityModel {
    ArrayList<Articles>articles;

    public UniversityModel(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "UniversityModel{" +
                "articles=" + articles +
                '}';
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

}
