package com.example.cansa_team;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;

import com.example.cansa_team.Data.FirebaseData;
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
    private String flag;

    //sự kiện lấy dữ liệu cho từng loại bằng
    private View.OnClickListener clickListenerBangA1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();

            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangA1 = FirebaseData.randomCauHoiBangA1();
            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_A1;

            bundle.putParcelableArrayList(LoadActivity.BANG_A1, cauHoiBangA1);

            bundle.putString(LoadActivity.FLAG, flag);

            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_A);

            bundle.putInt(flag + "name", R.string.tittile_license_a1);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    };

    private View.OnClickListener clickListenerBangA2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();
            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangA2 = FirebaseData.randomCauHoiBangA2();
            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_A2;
            bundle.putParcelableArrayList(LoadActivity.BANG_A2, cauHoiBangA2);
            bundle.putString(LoadActivity.FLAG, flag);
            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_A);
            bundle.putInt(flag + "name", R.string.tittile_license_a2);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickListenerBangA3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();
            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangA3_A4 = FirebaseData.randomCauHoiBangA3_A4();
            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_A3_A4;
            bundle.putParcelableArrayList(LoadActivity.BANG_A3_A4, cauHoiBangA3_A4);
            bundle.putString(LoadActivity.FLAG, flag);
            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_A);
            bundle.putInt(flag + "name", R.string.tittile_license_a3);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickListenerBangA4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();
            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangA3_A4 = FirebaseData.randomCauHoiBangA3_A4();
            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_A3_A4;
            bundle.putParcelableArrayList(LoadActivity.BANG_A3_A4, cauHoiBangA3_A4);
            bundle.putString(LoadActivity.FLAG, flag);
            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_A);
            bundle.putInt(flag + "name", R.string.tittile_license_a4);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickListenerBangB1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();
            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangB1 = FirebaseData.randomCauHoiBangB1();
            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_B1;
            bundle.putParcelableArrayList(LoadActivity.BANG_B1, cauHoiBangB1);
            bundle.putString(LoadActivity.FLAG, flag);
            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_B_C_D_E_F);
            bundle.putInt(flag + "name", R.string.tittile_license_b1);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickListenerBangB2= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();
            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangB2_C_D_E_F = FirebaseData.randomCauHoiBangB2_C_D_E_F();

            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_B2_C_D_E_F;
            bundle.putParcelableArrayList(LoadActivity.BANG_B2_C_D_E_F, cauHoiBangB2_C_D_E_F);
            bundle.putString(LoadActivity.FLAG, flag);
            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_B_C_D_E_F);
            bundle.putInt(flag + "name", R.string.tittile_license_b2);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickListenerBangC = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();
            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangB2_C_D_E_F = FirebaseData.randomCauHoiBangB2_C_D_E_F();

            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_B2_C_D_E_F;
            bundle.putParcelableArrayList(LoadActivity.BANG_B2_C_D_E_F, cauHoiBangB2_C_D_E_F);
            bundle.putString(LoadActivity.FLAG, flag);
            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_B_C_D_E_F);
            bundle.putInt(flag + "name", R.string.tittile_license_c);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickListenerBangD = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();
            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangB2_C_D_E_F = FirebaseData.randomCauHoiBangB2_C_D_E_F();

            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_B2_C_D_E_F;
            bundle.putParcelableArrayList(LoadActivity.BANG_B2_C_D_E_F, cauHoiBangB2_C_D_E_F);
            bundle.putString(LoadActivity.FLAG, flag);
            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_B_C_D_E_F);
            bundle.putInt(flag + "name", R.string.tittile_license_d);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickListenerBangE = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();
            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangB2_C_D_E_F = FirebaseData.randomCauHoiBangB2_C_D_E_F();

            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_B2_C_D_E_F;
            bundle.putParcelableArrayList(LoadActivity.BANG_B2_C_D_E_F, cauHoiBangB2_C_D_E_F);
            bundle.putString(LoadActivity.FLAG, flag);
            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_B_C_D_E_F);
            bundle.putInt(flag + "name", R.string.tittile_license_e);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickListenerBangF = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            Bundle bundle = new Bundle();
            //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
            ArrayList<CauHoi> cauHoiBangB2_C_D_E_F = FirebaseData.randomCauHoiBangB2_C_D_E_F();

            //tạo cờ xác định loại bằng chuyển qua
            flag = LoadActivity.BANG_B2_C_D_E_F;
            bundle.putParcelableArrayList(LoadActivity.BANG_B2_C_D_E_F, cauHoiBangB2_C_D_E_F);
            bundle.putString(LoadActivity.FLAG, flag);
            bundle.putString(flag + "count down", LoadActivity.COUNT_DOWN_BANG_B_C_D_E_F);
            bundle.putInt(flag + "name", R.string.tittile_license_fc);
            intent.putExtras(bundle);
            startActivity(intent);
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

        //tạo sự kiện chuyển màn hình cho từng nút button
        licenseA1.setOnClickListener(clickListenerBangA1);
        licenseA2.setOnClickListener(clickListenerBangA2);
        licenseA3.setOnClickListener(clickListenerBangA3);
        licenseA4.setOnClickListener(clickListenerBangA4);
        licenseB1.setOnClickListener(clickListenerBangB1);
        licenseB2.setOnClickListener(clickListenerBangB2);
        licenseC.setOnClickListener(clickListenerBangC);
        licenseD.setOnClickListener(clickListenerBangD);
        licenseE.setOnClickListener(clickListenerBangE);
        licenseFC.setOnClickListener(clickListenerBangF);
    }
}
