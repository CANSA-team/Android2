package com.example.cansa_team.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CauHoi implements Parcelable {
    public CauHoi() {
    }

    protected CauHoi(Parcel in) {
        hinhAnh = in.readString();
        cauHoi = in.readString();
        cauTraLoi = in.createStringArrayList();
        dapAn = in.readInt();
    }

    public static final Creator<CauHoi> CREATOR = new Creator<CauHoi>() {
        @Override
        public CauHoi createFromParcel(Parcel in) {
            return new CauHoi(in);
        }

        @Override
        public CauHoi[] newArray(int size) {
            return new CauHoi[size];
        }
    };

    public String getHinhAnh() {
        return hinhAnh;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public ArrayList<String> getCauTraLoi() {
        return cauTraLoi;
    }

    public int getDapAn() {
        return dapAn;
    }

    private String hinhAnh;
    private  String cauHoi;
    private ArrayList<String> cauTraLoi;
    private  int dapAn;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hinhAnh);
        dest.writeString(cauHoi);
        dest.writeStringList(cauTraLoi);
        dest.writeInt(dapAn);
    }

    @Override
    public String toString() {
        return "CauHoi{" +
                "hinhAnh='" + hinhAnh + '\'' +
                ", cauHoi='" + cauHoi + '\'' +
                ", cauTraLoi=" + cauTraLoi +
                ", dapAn=" + dapAn +
                '}';
    }
}
