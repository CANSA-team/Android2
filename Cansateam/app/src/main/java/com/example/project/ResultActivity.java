package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private ImageView home;
    private TextView total;
    private Button menu;
    /*
     *  su kien tra ve man hinh home tu man hinh ket qua
     *  activiy_result.xml -> activiy_main.xml
     */
    private View.OnClickListener rHome = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Bieu tuong home
        home = findViewById(R.id.home);
        // Button Menu
        menu = findViewById(R.id.btnMenu);
        // So cau tra loi dung / tong so cau (23/25)
        total =  findViewById(R.id.total);

        // Set Event
        home.setOnClickListener(rHome);
        menu.setOnClickListener(rHome);
    }
}
