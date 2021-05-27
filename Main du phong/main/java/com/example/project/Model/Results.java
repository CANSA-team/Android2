package com.example.project.Model;
/*
 * Class: Answer
 * Description: gom 2 tham so
 *  +answeredIndex:String thu tu cau hoi da tra loi
 *  +resourceImage:int setImage
 * => The hien doi tuong answered trong layout_list_result
 */
public class Results {
    private String answeredIndex;
    private int resourceImage;

    public Results(String answeredIndex, int resourceImage) {
        this.answeredIndex = answeredIndex;
        this.resourceImage = resourceImage;
    }

    public String getAnsweredIndex() {
        return answeredIndex;
    }

    public void setAnsweredIndex(String answer) {
        this.answeredIndex = answer;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }
}
