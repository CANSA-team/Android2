package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {
    private ImageView questionExit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_text);

        /*
         * Thoat khoi man hinh question
         */
        questionExit = findViewById(R.id.exit_question);
        questionExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(QuestionActivity.this,  CourseActivity.class);
                startActivity(intent);
            }
        });
    }
}
