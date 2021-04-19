package com.example.cansa_team_android2.Model;

public class HinhAnh {
    public HinhAnh() {
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HinhAnh(String link, String name) {
        this.link = link;
        this.name = name;
    }

    private String link;
    private String name;

}
