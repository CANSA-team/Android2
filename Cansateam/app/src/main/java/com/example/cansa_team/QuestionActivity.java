package com.example.cansa_team;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.cansa_team.Model.CauHoi;
import com.example.cansa_team.Model.Results;
import com.example.cansa_team.Model.TienIch;
import com.example.cansa_team.fragment.AbstractFragment;
import com.example.cansa_team.fragment.QuestionFragment;

import java.util.ArrayList;


public class QuestionActivity extends AppCompatActivity {
    private ImageView questionExit;
    private ImageView btnPrevious;
    private ImageView btnNext;
    private Button btnResult;
    private TextView txtCountdownTime;
    private TextView txtTitle;
    private FragmentTransaction fragmentTransaction;
    private AbstractFragment fragment;

    private CountDownTimer countDownTimer;
    private String countDownTime;
    public static int countCauHoi = 0;
    private int pos = 0;
    private Intent intent;
    private ArrayList<CauHoi> cauHois;
    private String flagCauHoi;
    public static ArrayList<Results> resultsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);
        txtCountdownTime = findViewById(R.id.countdown_time);
        btnResult = findViewById(R.id.btn_result);
        txtTitle = findViewById(R.id.question_title);

        //nếu mảng kết quả đã có giá trị thì gán lại bằng 0 và khởi tạo số câu hỏi theo đề;
        if(resultsArrayList.size() > 0) {
            resultsArrayList = new ArrayList<>();
        }

        //lấy dữ liệu từ màn hình MainActivity
        intent = getIntent();
        Bundle bundle = intent.getExtras();

        flagCauHoi = bundle.get(LoadActivity.FLAG).toString();
        cauHois = bundle.getParcelableArrayList(flagCauHoi);
        countDownTime = bundle.getString(flagCauHoi+"count down");

        //lấy số lượng câu hỏi
        countCauHoi = cauHois.size();

        //thiết lập thời gian đếm ngược của bài thi
        txtCountdownTime.setText(countDownTime);

        /*
         * Chuyen tu man hinh question ve man hinh main bang nut exit
         * activiy_question_text.xml -> activiy_main.xml
         */
        questionExit = findViewById(R.id.question_back);
        questionExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*
         * button chuyen den man hinh ket qua
         * activiy_question_text.xml -> activiy_resut.xml
         */

        //coutdown thời gian làm bài
        int time = TienIch.changeStringToTime(txtCountdownTime.getText().toString());
        countDownTimer = new CountDownTimer(time*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String strTime = TienIch.changeTimeToString((millisUntilFinished/1000));
                txtCountdownTime.setText(strTime);
            }

            @Override
            public void onFinish() {
                intent.setClass(QuestionActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

        //chạy giao diện lần đầu cập nhật dữ liệu
        updateUI();


        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                intent.setClass(QuestionActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(LoadActivity.FLAG, flagCauHoi);
                bundle.putString(flagCauHoi + "count down", countDownTime);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = (pos==(countCauHoi-1)) ? 0 : pos+1;
                fragment.updateUserInteraction();
                updateUI();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = (pos==0) ? (countCauHoi-1) : pos-1;
                fragment.updateUserInteraction();
                updateUI();
            }
        });
    }

    private void updateUI(){
        /*cập nhật giao diện
        nếu có hình dán QuestionImageFragment
        ngược lại dán QuestionNoneImageFragment
        */
        txtTitle.setText((pos+1)+"/"+countCauHoi);
            fragment = new QuestionFragment();


        fragment.setQuestion(cauHois.get(pos),pos);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_id, fragment);
        fragmentTransaction.commit();
    }
}
