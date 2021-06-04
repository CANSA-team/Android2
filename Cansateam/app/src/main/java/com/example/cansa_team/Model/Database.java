package com.example.cansa_team.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Database {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("cauhoi");

    String cauhoiId = mDatabase.push().getKey();

    // creating cauhoi object
     CauHoi cauHoi = new CauHoi();

    public void writeNewUser(String hinhAnh, String cauHoi, ArrayList<String> cauTraLoi, int dapAn, int loaiBang) {
        CauHoi cauhoi = new CauHoi(hinhAnh, cauHoi, cauTraLoi, dapAn, loaiBang);

        mDatabase.child("cauhoi").child(cauhoiId).setValue(cauHoi);
    }

}
