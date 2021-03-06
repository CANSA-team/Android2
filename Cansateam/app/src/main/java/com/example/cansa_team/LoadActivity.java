package com.example.cansa_team;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cansa_team.Data.FirebaseData;
import com.example.cansa_team.Model.CauHoi;
import com.example.cansa_team.Model.ConnectionReceiver;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoadActivity extends AppCompatActivity {

    //hằng sử dụng cho toàn chương trình
    public static final String BANG_A1 = "Bang A1";
    public static final String BANG_A2 = "Bang A2";
    public static final String BANG_A3_A4 = "Bang A3,A4";
    public static final String BANG_B1 = "Bang B1";
    public static final String BANG_B2_C_D_E_F = "Bang B2, C, D, E, F";
    public static final String FLAG = "flag";
    public static final String COUNT_DOWN_BANG_A = "15:00";
    public static final String COUNT_DOWN_BANG_B_C_D_E_F = "20:00";

    private TextView txtWarning;

    public static FirebaseDatabase firebaseDatabase;
    public static boolean flag;
    private  Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_layout);
        //chỉ duyệt data ở lần đầu vào màn hình
        flag = true;
        //kiểm tra có inernet không?
        if (ConnectionReceiver.isConnected()) {
            //Khởi tạo liên kết firebase tạo biến với từng loại bằng
            firebaseDatabase = FirebaseDatabase.getInstance();

            //Luồng Firebase
            firebaseDatabase.getReference().orderByValue().addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(flag) {
                        flag = false;
                        intent = new Intent(LoadActivity.this, MainActivity.class);
                        //khời tạo đối tượng loại bằng
                        FirebaseData.bangA1 = new ArrayList<>();
                        FirebaseData.bangA2 = new ArrayList<>();
                        FirebaseData.bangA3_A4 = new ArrayList<>();
                        FirebaseData.bangB1 = new ArrayList<>();
                        FirebaseData.bangB2_C_D_E_F = new ArrayList<>();

                        for (DataSnapshot data : snapshot.getChildren()) {
                            //lưu dữ liệu vào đối tượng theo từng loại bằng
                            switch (data.getKey()) {
                                case BANG_A1:
                                    for (DataSnapshot dataChildren : data.getChildren()) {
                                        FirebaseData.bangA1.add(dataChildren.getValue(CauHoi.class));
                                    }
                                    break;
                                case BANG_A2:
                                    for (DataSnapshot dataChildren : data.getChildren()) {
                                        FirebaseData.bangA2.add(dataChildren.getValue(CauHoi.class));
                                    }
                                    break;
                                case BANG_A3_A4:
                                    for (DataSnapshot dataChildren : data.getChildren()) {
                                        FirebaseData.bangA3_A4.add(dataChildren.getValue(CauHoi.class));
                                    }
                                    break;
                                case BANG_B1:
                                    for (DataSnapshot dataChildren : data.getChildren()) {
                                        FirebaseData.bangB1.add(dataChildren.getValue(CauHoi.class));
                                    }
                                    break;
                                case BANG_B2_C_D_E_F:
                                    for (DataSnapshot dataChildren : data.getChildren()) {
                                        FirebaseData.bangB2_C_D_E_F.add(dataChildren.getValue(CauHoi.class));
                                    }
                                    break;
                            }
                        }
                        //chuyển đến màn hình main
                        finish();
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else {
            //khi không có internet
            String warning = "Không có kết nối Internet!";
            Toast.makeText(this,warning,Toast.LENGTH_LONG).show();
            txtWarning = findViewById(R.id.txt_warning);
            txtWarning.setText(warning);
        }
    }
}
