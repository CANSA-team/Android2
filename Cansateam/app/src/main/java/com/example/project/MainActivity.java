package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Chuyen man hinh tu main sang man hinh cau hoi bang A1 (cau hoi ko sa hinh)
         * activiy_main.xml -> activiy_question_text.xml
         */
        licenseA1 = findViewById(R.id.license_a1);
        licenseA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(intent);
            }
        });

        /*
         * Chuyen man hinh tu main sang man hinh cau hoi bang A2 (cau hoi sa hinh)
         * activiy_main.xml -> activiy_question_img.xml
         */
        LinearLayout licenseA2 = findViewById(R.id.license_a2);
        licenseA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuestionImgActivity.class);
                startActivity(intent);
            }
        });

        /*
         * GET DATA
         * license : giay phep
         */
         licenseA3 = findViewById(R.id.license_a3);
         licenseA4 = findViewById(R.id.license_a4);
         licenseB1 = findViewById(R.id.license_b1);
         licenseB2 = findViewById(R.id.license_b2);
         licenseC = findViewById(R.id.license_c);
         licenseD = findViewById(R.id.license_d);
         licenseE = findViewById(R.id.license_e);
         licenseFC = findViewById(R.id.license_fc);
    }
}
