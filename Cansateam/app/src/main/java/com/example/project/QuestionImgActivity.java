package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionImgActivity extends AppCompatActivity {
    private ImageView questionExit;
    private ImageView btnPrevious;
    private ImageView btnNext;
    private ImageView imgQuestion;
    private Button btnResult;
    //cau tra loi
    private LinearLayout answer1;
    private LinearLayout answer2;
    private LinearLayout answer3;
    private LinearLayout answer4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_img);

        /*
         * Chuyen tu man hinh question ve man hinh main bang nut exit
         * activiy_question_text.xml -> activiy_main.xml
         */
        questionExit = findViewById(R.id.question_back);
        questionExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionImgActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        /*
         * button chuyen den man hinh ket qua
         * activiy_question_text.xml -> activiy_resut.xml
         */
        btnResult = findViewById(R.id.btn_result);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionImgActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

        // nut tro lai cau hoi phia truoc
        btnPrevious = findViewById(R.id.btn_previous);
        // but tro lai cau hoi tiep theo
        btnNext = findViewById(R.id.btn_next);
        // ImageView chua sa hinh
        imgQuestion = findViewById(R.id.img_question);

        // Cac cau tra loi
        answer1 =  findViewById(R.id.answer_1);
        answer2 =  findViewById(R.id.answer_2);
        answer3 =  findViewById(R.id.answer_3);
        answer4 =  findViewById(R.id.answer_4);
    }
}
