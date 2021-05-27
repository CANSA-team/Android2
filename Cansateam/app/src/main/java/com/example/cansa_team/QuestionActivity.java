package com.example.cansa_team;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cansa_team.R;

public class QuestionActivity extends AppCompatActivity {
    private ImageView questionExit;
    private ImageView btnPrevious;
    private ImageView btnNext;
    private Button btnResult;
    //cau tra loi
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        /*
         * Chuyen tu man hinh question ve man hinh main bang nut exit
         * activiy_question_text.xml -> activiy_main.xml
         */
        questionExit = findViewById(R.id.question_back);
        questionExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
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
                Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

        // Nut tro lai cau hoi phia truoc
        btnPrevious = findViewById(R.id.btn_previous);
        // Nut tro lai cau hoi tiep theo
        btnNext = findViewById(R.id.btn_next);
    }

}
