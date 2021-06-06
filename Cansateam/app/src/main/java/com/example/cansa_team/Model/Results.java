package com.example.cansa_team.Model;

import com.example.cansa_team.R;

public class Results {
    private int answeredIndex;
    private int resourceImage;
    private int choses;
    public int getChoses() {
        return choses;
    }

    public void setChoses(int choses) {
        this.choses = choses;
    }

    public Results(int answeredIndex) {
        this.answeredIndex = answeredIndex;
        this.resourceImage = R.drawable.ic_false;
        this.choses = 0;
    }

    public int getAnsweredIndex() {
        return answeredIndex;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }
}
