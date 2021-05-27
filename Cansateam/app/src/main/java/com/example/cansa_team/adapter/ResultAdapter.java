package com.example.cansa_team.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cansa_team.Model.Results;
import com.example.cansa_team.R;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder>{
    private Context mContext;
    private ArrayList<Results> mListResult;
    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_results,parent,false);
        return new ResultViewHolder(view);
    }

    public ResultAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(ArrayList<Results> mList){
        this.mListResult = mList;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        Results results = mListResult.get(position);
        if (results == null){
            return;
        }
        holder.img.setImageResource(results.getResourceImage());
        holder.name.setText(results.getAnsweredIndex());
    }

    @Override
    public int getItemCount() {
        if (mListResult != null){
            return mListResult.size();
        }
        return 0;
    }

    // Class
    public class ResultViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name;
        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_answer_number);
            img = itemView.findViewById(R.id.img_check);
        }
    }
}
