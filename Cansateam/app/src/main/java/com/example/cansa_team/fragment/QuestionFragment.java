package com.example.cansa_team.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cansa_team.Model.CauHoi;
import com.example.cansa_team.Model.Results;
import com.example.cansa_team.Model.TienIch;
import com.example.cansa_team.QuestionActivity;
import com.example.cansa_team.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class QuestionFragment extends AbstractFragment {

    private Results results;
    private int pos;
    private CauHoi cauHoi;

    private TextView txtCauHoi;
    private ImageView imgHinhAnh;
    private RadioGroup answerGroup;
    private RadioButton btnAnswer;


    @Override
    public void setQuestion(CauHoi cauHoi, int pos) {
        this.cauHoi = cauHoi;
        this.pos = pos;
    }

    @Override
    public void updateUserInteraction() {
        //kiểm tra đúng sai và thiết lập biến hình ảnh đúng sai
        if (answerGroup.getCheckedRadioButtonId() == cauHoi.getDapAn()) {
            results.setResourceImage(R.drawable.ic_true);
        } else if ((answerGroup.getCheckedRadioButtonId() == cauHoi.getDapAn())) {
            results.setResourceImage(R.drawable.ic_false);
        }

        //thiết lập biến lựa chọn
        results.setChoses(answerGroup.getCheckedRadioButtonId());
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        if(cauHoi.getHinhAnh().length() != 0){
            view = inflater.inflate(R.layout.fragment_question_image, container, false);
            //load hình từ firebase
            imgHinhAnh = view.findViewById(R.id.img);
            //tự động load hình từ internet
            Picasso.get().load(cauHoi.getHinhAnh()).into(imgHinhAnh);
        }
        else {
            view = inflater.inflate(R.layout.fragment_question_none_image, container, false);
        }

        txtCauHoi = view.findViewById(R.id.txtCauHoi);
        answerGroup = view.findViewById(R.id.answer_group);

        //nếu mảng kết quả chưa có phần tử thì khởi tạo số phần tử theo từng loại bằng
        if (QuestionActivity.resultsArrayList.size() == 0) {
            QuestionActivity.resultsArrayList = TienIch.createResultsByCount(QuestionActivity.countCauHoi);
        }

        //lấy kết quả từ mảng kết quả theo vị trí pos
        results = QuestionActivity.resultsArrayList.get(pos);

        //set câu hỏi
        txtCauHoi.setText(cauHoi.getCauHoi().trim());

        //duyệt mảng câu trả lời thêm vào RadioButton Group
        int id = 0;
        for (String answer : cauHoi.getCauTraLoi()) {
            //lấy giao diện RadioButton và cấu chỉnh button
            View btn_answer_view = inflater.inflate(R.layout.radio_button_answer, container, false);
            btnAnswer = btn_answer_view.findViewById(R.id.btn_answer);
            btnAnswer.setId(id++);
            btnAnswer.setText(answer);

            //thêm RadioButton vào RadioGroup
            answerGroup.addView(btnAnswer);

        }

        //check vào button đã được chọn (chọn button đầu tiên nếu chưa chọn)
        answerGroup.check(results.getChoses());
        return view;
    }
}