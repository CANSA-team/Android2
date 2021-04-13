package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CourseActivity extends AppCompatActivity {
    private ImageView exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);


        /*
         *  Doi man hinh : chuyen ve man hinh MainActivity
         */
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CourseActivity.this,  MainActivity.class);
                startActivity(intent);
            }
        });

        /*
         *  chuyen sang man hinh question bang A1
         */
        LinearLayout licenseA1 =findViewById(R.id.license_a1);
        licenseA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CourseActivity.this,  QuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}
