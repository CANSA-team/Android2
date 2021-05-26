package com.example.cansa_team.Model;

import java.util.ArrayList;

public class CauHoi {
    public CauHoi() {
    }

    public CauHoi(String hinhAnh, String cauHoi, ArrayList<String> cauTraLoi, int dapAn) {
        this.hinhAnh = hinhAnh;
        this.cauHoi = cauHoi;
        this.cauTraLoi = cauTraLoi;
        this.dapAn = dapAn;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public ArrayList<String> getCauTraLoi() {
        return cauTraLoi;
    }

    public void setCauTraLoi(ArrayList<String> cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }

    public int getDapAn() {
        return dapAn;
    }

    public void setDapAn(int dapAn) {
        this.dapAn = dapAn;
    }

    private String hinhAnh;
    private  String cauHoi;
    private ArrayList<String> cauTraLoi;
    private  int dapAn;



}
