package com.example.cansa_team_android2.Model;

import java.util.ArrayList;

public class CauHoi {
    public CauHoi() {
    }

    public CauHoi(HinhAnh hinhAnh, String cauHoi, ArrayList<String> cauTraLoi, int dapAn, int loaiBang) {
        this.hinhAnh = hinhAnh;
        this.cauHoi = cauHoi;
        this.cauTraLoi = cauTraLoi;
        this.dapAn = dapAn;
        this.loaiBang = loaiBang;
    }

    public HinhAnh getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(HinhAnh hinhAnh) {
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

    public int getLoaiBang() {
        return loaiBang;
    }

    public void setLoaiBang(int loaiBang) {
        this.loaiBang = loaiBang;
    }

    private HinhAnh hinhAnh;
    private  String cauHoi;
    private ArrayList<String> cauTraLoi;
    private  int dapAn;
    private  int loaiBang;


}
