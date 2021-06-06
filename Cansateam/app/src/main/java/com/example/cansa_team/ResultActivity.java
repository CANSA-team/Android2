package com.example.cansa_team;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cansa_team.Data.FirebaseData;
import com.example.cansa_team.Model.CauHoi;
import com.example.cansa_team.Model.Results;
import com.example.cansa_team.Model.TienIch;
import com.example.cansa_team.adapter.ResultAdapter;

import java.util.ArrayList;
import java.util.Random;

public class ResultActivity extends AppCompatActivity {
    private Button btnBackText;
    private RecyclerView listResult;
    private ImageView home;
    private TextView total;
    private TextView txtResult;

    private String totalResult;
    private ArrayList<Results> resultsArrayList;
    private int deathPoint;
    private int countResult;
    private int countTrueChose;
    private String flagCauHoi;
    private Intent intent;
    private ResultAdapter resultAdapter;
    private String countDownTime;


    private static final String SUCCESS  = "Đậu";
    private static final String FAIL  = "Trượt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home = findViewById(R.id.home);
        total =  findViewById(R.id.total);
        listResult = findViewById(R.id.listResult);
        txtResult = findViewById(R.id.txt_result);
        btnBackText = findViewById(R.id.btnBackText);

        //lấy dữ liệu từ màn hình QuestionActivity
        Random random = new Random();
        intent = getIntent();
        Bundle bundle = intent.getExtras();

        resultAdapter = new ResultAdapter(this);
        resultsArrayList = QuestionActivity.resultsArrayList;
        countResult = resultsArrayList.size();
        flagCauHoi = bundle.get(LoadActivity.FLAG).toString();
        countDownTime = bundle.getString(flagCauHoi+"count down");

        //đếm số lượng câu đúng
        countTrueChose = TienIch.countTrueChoseResults(resultsArrayList);

        //tạo ngẫu nhiên 1 câu điểm liệt
        deathPoint = random.nextInt(countResult-1);

        /*
        * nếu câu điểm liệt sai hoặc đúng dưới 90% tổng số câu => trượt
        * ngược lại => đậu
        * */
        if(resultsArrayList.get(deathPoint).getResourceImage() == R.drawable.ic_false || (countResult*0.9)>countTrueChose)
        {
            txtResult.setText(FAIL);
        }else
        {
            txtResult.setText(SUCCESS);
        }

        totalResult = countTrueChose +"/"+resultsArrayList.size();
        //hiển thị ra màn hình kết quả đậu trượt
        total.setText(totalResult);

        // Set Event
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnBackText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, QuestionActivity.class);
                Bundle bundle = new Bundle();
                //lấy ngẫu nhiên số lượng câu hỏi theo loại bằng
                ArrayList<CauHoi> cauHois = new ArrayList<>();
                switch (flagCauHoi){
                    case LoadActivity.BANG_A1:
                        cauHois = TienIch.selectRandomElements(FirebaseData.bangA1, countResult);
                        break;
                    case LoadActivity.BANG_A2:
                        cauHois = TienIch.selectRandomElements(FirebaseData.bangA2, countResult);
                        break;
                    case LoadActivity.BANG_A3_A4:
                        cauHois = TienIch.selectRandomElements(FirebaseData.bangA3_A4, countResult);
                        break;
                    case LoadActivity.BANG_B1:
                        cauHois = TienIch.selectRandomElements(FirebaseData.bangB1, countResult);
                        break;
                    case LoadActivity.BANG_B2_C_D_E_F:
                        cauHois = TienIch.selectRandomElements(FirebaseData.bangB2_C_D_E_F, countResult);
                        break;
                }
                //tạo cờ xác định loại bằng chuyển qua
                bundle.putParcelableArrayList(flagCauHoi, cauHois);
                bundle.putString(LoadActivity.FLAG, flagCauHoi);
                bundle.putString(flagCauHoi + "count down", countDownTime);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });

        //SetAdapter, Ham getResults()->ArrayList<Results>
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        listResult.setLayoutManager(gridLayoutManager);
        resultAdapter.setData(resultsArrayList);
        listResult.setAdapter(resultAdapter);
    }
}
