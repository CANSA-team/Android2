package com.example.cansa_team;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import com.example.cansa_team.Model.CauHoi;
import com.example.cansa_team.Model.TienIch;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

import android.view.View;
import android.widget.LinearLayout;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String BANG_A1 = "Bang A1";
    public static final String BANG_A2 = "Bang A2";
    public static final String BANG_A3_A4 = "Bang A3,A4";
    public static final String BANG_B1 = "Bang B1";
    public static final String BANG_B2_C_D_E_F = "Bang B2, C, D, E, F";
    public static final int COUNT_BANG_A = 20;
    public static final int COUNT_BANG_B_C_D_E_F = 30;
    public static final String FLAG = "flag";
    public static final String COUNT_DOWN_BANG_A = "15:00";
    public static final String COUNT_DOWN_BANG_B_C_D_E_F = "20:00";

    public static ArrayList<CauHoi> arrBangA1;
    public static ArrayList<CauHoi> arrBangA2;
    public static ArrayList<CauHoi> arrBangA3_A4;
    public static ArrayList<CauHoi> arrBangB1;
    public static ArrayList<CauHoi> arrBangB2_C_D_E_F;

    private LinearLayout licenseA1;
    private LinearLayout licenseA2;
    private LinearLayout licenseA3;
    private LinearLayout licenseA4;
    private LinearLayout licenseB1;
    private LinearLayout licenseB2;
    private LinearLayout licenseC;
    private LinearLayout licenseD;
    private LinearLayout licenseE;
    private LinearLayout licenseFC;
    private DatabaseReference bangA1;
    private DatabaseReference bangA2;
    private DatabaseReference bangA3_A4;
    private  DatabaseReference bangB1;
    private  DatabaseReference bangB2_C_D_E_F;
    private  FirebaseDatabase firebaseDatabase;
    private String flag;

    //sự kiện lấy dữ liệu cho từng loại bằng
    private View.OnClickListener clickListenerBangA1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(arrBangA1.size() != 0) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                Bundle bundle = new Bundle();
                //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
                ArrayList<CauHoi> cauHoiBangA1 = TienIch.selectRandomElements(arrBangA1, COUNT_BANG_A);
                //tạo cờ xác định loại bằng chuyển qua
                flag = BANG_A1;
                bundle.putParcelableArrayList(BANG_A1, cauHoiBangA1);
                bundle.putString(FLAG, flag);
                bundle.putString(flag + "count down", COUNT_DOWN_BANG_A);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };

    private View.OnClickListener clickListenerBangA2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(arrBangA2.size() != 0) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                Bundle bundle = new Bundle();
                //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
                ArrayList<CauHoi> cauHoiBangA2 = TienIch.selectRandomElements(arrBangA2, COUNT_BANG_A);
                //tạo cờ xác định loại bằng chuyển qua
                flag = BANG_A2;
                bundle.putParcelableArrayList(BANG_A2, cauHoiBangA2);
                bundle.putString(FLAG, flag);
                bundle.putString(flag + "count down", COUNT_DOWN_BANG_A);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };

    private View.OnClickListener clickListenerBangA3_A4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(arrBangA3_A4.size() != 0) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                Bundle bundle = new Bundle();
                //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
                ArrayList<CauHoi> cauHoiBangA3_A4 = TienIch.selectRandomElements(arrBangA3_A4, COUNT_BANG_A);
                //tạo cờ xác định loại bằng chuyển qua
                flag = BANG_A3_A4;
                bundle.putParcelableArrayList(BANG_A3_A4, cauHoiBangA3_A4);
                bundle.putString(FLAG, flag);
                bundle.putString(flag + "count down", COUNT_DOWN_BANG_A);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };

    private View.OnClickListener clickListenerBangB1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(arrBangB1.size() != 0) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                Bundle bundle = new Bundle();
                //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
                ArrayList<CauHoi> cauHoiBangB1 = TienIch.selectRandomElements(arrBangB1, COUNT_BANG_B_C_D_E_F);
                //tạo cờ xác định loại bằng chuyển qua
                flag = BANG_B1;
                bundle.putParcelableArrayList(BANG_B1, cauHoiBangB1);
                bundle.putString(FLAG, flag);
                bundle.putString(flag + "count down", COUNT_DOWN_BANG_B_C_D_E_F);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };

    private View.OnClickListener clickListenerBangB2_C_D_E_F = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(arrBangB2_C_D_E_F.size() != 0) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                Bundle bundle = new Bundle();
                //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
                ArrayList<CauHoi> cauHoiBangB2_C_D_E_F = TienIch.selectRandomElements(arrBangB2_C_D_E_F, COUNT_BANG_B_C_D_E_F);
                //tạo cờ xác định loại bằng chuyển qua
                flag = BANG_B2_C_D_E_F;
                bundle.putParcelableArrayList(BANG_B2_C_D_E_F, cauHoiBangB2_C_D_E_F);
                bundle.putString(FLAG, flag);
                bundle.putString(flag + "count down", COUNT_DOWN_BANG_B_C_D_E_F);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lấy các nút button từ activity
        licenseA1 = findViewById(R.id.license_a1);
        licenseA2 = findViewById(R.id.license_a2);
        licenseA3 = findViewById(R.id.license_a3);
        licenseA4 = findViewById(R.id.license_a4);
        licenseB1 = findViewById(R.id.license_b1);
        licenseB2 = findViewById(R.id.license_b2);
        licenseC = findViewById(R.id.license_c);
        licenseD = findViewById(R.id.license_d);
        licenseE = findViewById(R.id.license_e);
        licenseFC = findViewById(R.id.license_fc);

        //khởi tạo mảng ArrayList<CauHoi>
        arrBangA1 = new ArrayList<>();
        arrBangA2= new ArrayList<>();
        arrBangA3_A4= new ArrayList<>();
        arrBangB1= new ArrayList<>();
        arrBangB2_C_D_E_F= new ArrayList<>();

        //Khởi tạo liên kết firebase tạo biến với từng loại bằng
        firebaseDatabase = FirebaseDatabase.getInstance();
        bangA1 = firebaseDatabase.getReference(BANG_A1);
        bangA2 = firebaseDatabase.getReference(BANG_A2);
        bangA3_A4 = firebaseDatabase.getReference(BANG_A3_A4);
        bangB1 = firebaseDatabase.getReference(BANG_B1);
        bangB2_C_D_E_F = firebaseDatabase.getReference(BANG_B2_C_D_E_F);

        //lấy dữ liệu từng loại bằng
        bangA1.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {
                arrBangA1.add(snapshot.getValue(CauHoi.class));
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        bangA2.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {
                arrBangA2.add(snapshot.getValue(CauHoi.class));
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        bangA3_A4.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {
                arrBangA3_A4.add(snapshot.getValue(CauHoi.class));
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        bangB1.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {
                arrBangB1.add(snapshot.getValue(CauHoi.class));
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        bangB2_C_D_E_F.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {
                arrBangB2_C_D_E_F.add(snapshot.getValue(CauHoi.class));
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        //tạo sự kiện chuyển màn hình cho từng nút button
        licenseA1.setOnClickListener(clickListenerBangA1);
        licenseA2.setOnClickListener(clickListenerBangA2);
        licenseA3.setOnClickListener(clickListenerBangA3_A4);
        licenseA4.setOnClickListener(clickListenerBangA3_A4);
        licenseB1.setOnClickListener(clickListenerBangB1);
        licenseB2.setOnClickListener(clickListenerBangB2_C_D_E_F);
        licenseC.setOnClickListener(clickListenerBangB2_C_D_E_F);
        licenseD.setOnClickListener(clickListenerBangB2_C_D_E_F);
        licenseE.setOnClickListener(clickListenerBangB2_C_D_E_F);
        licenseFC.setOnClickListener(clickListenerBangB2_C_D_E_F);

    }
}
