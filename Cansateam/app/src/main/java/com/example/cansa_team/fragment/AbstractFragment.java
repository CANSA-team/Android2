package com.example.cansa_team.fragment;


import androidx.fragment.app.Fragment;

import com.example.cansa_team.Model.CauHoi;

public abstract class AbstractFragment extends Fragment {
    public abstract void setQuestion(CauHoi cauHoi,int pos);
    public abstract void updateUserInteraction();
}