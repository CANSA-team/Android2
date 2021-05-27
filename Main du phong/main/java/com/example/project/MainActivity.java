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
    private View.OnClickListener moveQuestionActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            startActivity(intent);
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Chuyen man hinh tu main sang man hinh cau hoi
         * activiy_main.xml -> activiy_question.xml
         */
        licenseA1 = findViewById(R.id.license_a1);
        licenseA1.setOnClickListener(moveQuestionActivity);

        licenseA2 = findViewById(R.id.license_a2);
        licenseA2.setOnClickListener(moveQuestionActivity);

        licenseA3 = findViewById(R.id.license_a3);
        licenseA3.setOnClickListener(moveQuestionActivity);

        licenseA4 = findViewById(R.id.license_a4);
        licenseA4.setOnClickListener(moveQuestionActivity);

        licenseB1 = findViewById(R.id.license_b1);
        licenseB1.setOnClickListener(moveQuestionActivity);

        licenseB2 = findViewById(R.id.license_b2);
        licenseB2.setOnClickListener(moveQuestionActivity);

        licenseC = findViewById(R.id.license_c);
        licenseC.setOnClickListener(moveQuestionActivity);

        licenseD = findViewById(R.id.license_d);
        licenseD.setOnClickListener(moveQuestionActivity);

        licenseE = findViewById(R.id.license_e);
        licenseE.setOnClickListener(moveQuestionActivity);

        licenseFC = findViewById(R.id.license_fc);
        licenseFC.setOnClickListener(moveQuestionActivity);
    }
}
