package com.example.cansa_team.Data;

import com.example.cansa_team.Model.CauHoi;
import com.example.cansa_team.Model.TienIch;

import java.util.ArrayList;

public class FirebaseData {
    public static ArrayList<CauHoi> bangA1;
    public static ArrayList<CauHoi> bangA2;
    public static ArrayList<CauHoi> bangA3_A4;
    public static ArrayList<CauHoi> bangB1;
    public static ArrayList<CauHoi> bangB2_C_D_E_F;

    public static ArrayList<CauHoi> randomCauHoiBangA1(){
        ArrayList<CauHoi> cauHoiBangA1 = new ArrayList<>();
        cauHoiBangA1.addAll(TienIch.selectRandomElements(bangA1, 1,1,13));
        cauHoiBangA1.addAll(TienIch.selectRandomElements(bangA1, 7,14,72));
        cauHoiBangA1.addAll(TienIch.selectRandomElements(bangA1, 1,73,75));
        cauHoiBangA1.addAll(TienIch.selectRandomElements(bangA1, 1,76,80));
        cauHoiBangA1.addAll(TienIch.selectRandomElements(bangA1, 5,81,115));
        cauHoiBangA1.addAll(TienIch.selectRandomElements(bangA1, 5,116,150));
        return cauHoiBangA1;
    }

    public static ArrayList<CauHoi> randomCauHoiBangA2(){
        ArrayList<CauHoi> cauHoiBangA2 = new ArrayList<>();
        cauHoiBangA2.addAll(TienIch.selectRandomElements(FirebaseData.bangA2, 1,1,21));
        cauHoiBangA2.addAll(TienIch.selectRandomElements(FirebaseData.bangA2, 7,22,131));
        cauHoiBangA2.addAll(TienIch.selectRandomElements(FirebaseData.bangA2, 1,132,145));
        cauHoiBangA2.addAll(TienIch.selectRandomElements(FirebaseData.bangA2, 1,146,170));
        cauHoiBangA2.addAll(TienIch.selectRandomElements(FirebaseData.bangA2, 5,171,270));
        cauHoiBangA2.addAll(TienIch.selectRandomElements(FirebaseData.bangA2, 5,271,365));
        return cauHoiBangA2;
    }

    public static ArrayList<CauHoi> randomCauHoiBangA3_A4(){
        ArrayList<CauHoi> cauHoiBangA3_A4 = new ArrayList<>();
        cauHoiBangA3_A4.addAll(TienIch.selectRandomElements(FirebaseData.bangA3_A4, 1,1,21));
        cauHoiBangA3_A4.addAll(TienIch.selectRandomElements(FirebaseData.bangA3_A4, 7,22,131));
        cauHoiBangA3_A4.addAll(TienIch.selectRandomElements(FirebaseData.bangA3_A4, 1,132,145));
        cauHoiBangA3_A4.addAll(TienIch.selectRandomElements(FirebaseData.bangA3_A4, 1,146,175));
        cauHoiBangA3_A4.addAll(TienIch.selectRandomElements(FirebaseData.bangA3_A4, 1,176,200));
        cauHoiBangA3_A4.addAll(TienIch.selectRandomElements(FirebaseData.bangA3_A4, 5,201,300));
        cauHoiBangA3_A4.addAll(TienIch.selectRandomElements(FirebaseData.bangA3_A4, 4,301,390));
        return cauHoiBangA3_A4;
    }

    public static ArrayList<CauHoi> randomCauHoiBangB1(){
        ArrayList<CauHoi> cauHoiBangB1 = new ArrayList<>();
        cauHoiBangB1.addAll(TienIch.selectRandomElements(FirebaseData.bangB1, 1,1,21));
        cauHoiBangB1.addAll(TienIch.selectRandomElements(FirebaseData.bangB1, 7,22,131));
        cauHoiBangB1.addAll(TienIch.selectRandomElements(FirebaseData.bangB1, 1,132,145));
        cauHoiBangB1.addAll(TienIch.selectRandomElements(FirebaseData.bangB1, 2,146,170));
        cauHoiBangB1.addAll(TienIch.selectRandomElements(FirebaseData.bangB1, 1,171,225));
        cauHoiBangB1.addAll(TienIch.selectRandomElements(FirebaseData.bangB1, 9,226,325));
        cauHoiBangB1.addAll(TienIch.selectRandomElements(FirebaseData.bangB1, 9,326,420));
        return cauHoiBangB1;
    }

    public static ArrayList<CauHoi> randomCauHoiBangB2_C_D_E_F(){
        ArrayList<CauHoi> cauHoiBangB2_C_D_E_F = new ArrayList<>();
        cauHoiBangB2_C_D_E_F.addAll(TienIch.selectRandomElements(FirebaseData.bangB2_C_D_E_F, 1,1,21));
        cauHoiBangB2_C_D_E_F.addAll(TienIch.selectRandomElements(FirebaseData.bangB2_C_D_E_F, 7,22,131));
        cauHoiBangB2_C_D_E_F.addAll(TienIch.selectRandomElements(FirebaseData.bangB2_C_D_E_F, 1,132,145));
        cauHoiBangB2_C_D_E_F.addAll(TienIch.selectRandomElements(FirebaseData.bangB2_C_D_E_F, 1,146,175));
        cauHoiBangB2_C_D_E_F.addAll(TienIch.selectRandomElements(FirebaseData.bangB2_C_D_E_F, 1,176,200));
        cauHoiBangB2_C_D_E_F.addAll(TienIch.selectRandomElements(FirebaseData.bangB2_C_D_E_F, 1,201,255));
        cauHoiBangB2_C_D_E_F.addAll(TienIch.selectRandomElements(FirebaseData.bangB2_C_D_E_F, 9,256,355));
        cauHoiBangB2_C_D_E_F.addAll(TienIch.selectRandomElements(FirebaseData.bangB2_C_D_E_F, 9,356,450));
        return cauHoiBangB2_C_D_E_F;
    }
}
