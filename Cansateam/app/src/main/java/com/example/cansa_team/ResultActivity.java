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

import com.example.cansa_team.Model.Results;
import com.example.cansa_team.adapter.ResultAdapter;
import com.example.cansa_team.R;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private RecyclerView listResult;
    private ResultAdapter resultAdapter;
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

        //Lay doi tuong RecyclerView trong activity__result
        listResult = findViewById(R.id.listResult);
        resultAdapter = new ResultAdapter(this);

        //SetAdapter, Ham getResults()->ArrayList<Results>
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        listResult.setLayoutManager(gridLayoutManager);
        resultAdapter.setData(getResults());
        listResult.setAdapter(resultAdapter);

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

    /*
     * Tra ve ArrayList<Results> de set Adapter
     * new Results(answeredIndex,resourceImage)
     *  -answeredIndex:String thu tu cau tra loi
     *  -resourceImage: Cau tra loi
     *    +Dung set-> R.drawable.ic_true,
     *    +Sai set-> R.drawable.ic_false
     */
    private ArrayList<Results> getResults(){
        ArrayList<Results> resultsArrayList = new ArrayList<>();
        resultsArrayList.add(new Results("Cau 1", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 2", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 3", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 4", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 5", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 6", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 7", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 8", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 9", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 10", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 1", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 2", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 3", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 4", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 5", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 6", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 7", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 8", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 9", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 10", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 1", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 2", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 3", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 4", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 5", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 6", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 7", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 8", R.drawable.ic_false));
        resultsArrayList.add(new Results("Cau 9", R.drawable.ic_true));
        resultsArrayList.add(new Results("Cau 10", R.drawable.ic_false));
        return resultsArrayList;
    }
}
