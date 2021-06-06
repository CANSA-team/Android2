package com.example.cansa_team.Model;

import com.example.cansa_team.R;

import java.util.ArrayList;
import java.util.Random;

public class TienIch {
    public static <E> ArrayList<E> selectRandomElements(ArrayList<E> list, int amount)
    {
        // Avoid a deadlock
        if (amount >= list.size())
        {
            return list;
        }

        ArrayList<E> selected = new ArrayList<>();
        Random random = new Random();
        int listSize = list.size();

        // Get a random item until we got the requested amount
        while (selected.size() < amount)
        {
            int randomIndex = random.nextInt(listSize);
            E element = list.get(randomIndex);

            if (!selected.contains(element))
            {
                selected.add(element);
            }
        }

        return selected;
    }

    public static String changeTimeToString(long time){
        String result = "";

        long seconds = 0;
        long minute = 0;

        seconds = time % 60;
        minute = time / 60;

        result = minute+":"+seconds;

        return  result;
    }

    public static int changeStringToTime(String str){
        int result = 0;

        String[] strs = str.split(":");

        int seconds = Integer.parseInt(strs[1]);
        int minute = Integer.parseInt(strs[0])*60;

        result = seconds + minute;

        return  result;
    }

    public static int countTrueChoseResults(ArrayList<Results> results){
        int count = 0;

        for (Results result:
             results) {
            if(result.getResourceImage() == R.drawable.ic_true){
                count++;
            }
        }

        return  count;
    }

    public static ArrayList<Results> createResultsByCount(int count){
        ArrayList<Results> results =new ArrayList<>();
        for (int i = 0; i<count;i++){
            results.add(new Results(i));
        }
       return results;
    }
}
