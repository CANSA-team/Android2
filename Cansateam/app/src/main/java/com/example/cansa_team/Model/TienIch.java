package com.example.cansa_team.Model;

import com.example.cansa_team.R;

import java.util.ArrayList;
import java.util.Random;

public class TienIch {
    public static <E> ArrayList<E> selectRandomElements(ArrayList<E> list, int amount, int start, int end)
    {
        // Avoid a deadlock
        if (amount >= list.size())
        {
            return list;
        }

        ArrayList<E> selected = new ArrayList<>();
        Random random = new Random();

        // Get a random item until we got the requested amount
        while (selected.size() < amount)
        {
            int randomIndex = -1;
            while (randomIndex < (start-1)){
                randomIndex = random.nextInt(end);
            }
            E element = list.get(randomIndex);

            if (!selected.contains(element))
            {
                selected.add(element);
            }
        }

        return selected;
    }

    public static ArrayList<Integer> RandomDeathPoint(int n,int lengthCauHoi){
        ArrayList<Integer> deathPoints = new ArrayList<Integer>();
        Random random = new Random();
        while (deathPoints.size() < n)
        {
            int randomIndex = -1;
            randomIndex = random.nextInt(lengthCauHoi);

            if (!deathPoints.contains(randomIndex))
            {
                deathPoints.add(randomIndex);
            }
        }
        return deathPoints;
    }

    public static boolean checkResult(ArrayList<Results> resultsArrayList,ArrayList<Integer> deathPoints,int target){
        boolean result = true;

        if(countTrueChoseResults(resultsArrayList) < target)
        {
            result = false;
        }

        for (int deathPoint:
             deathPoints) {
            if((resultsArrayList.get(deathPoint).getResourceImage() == R.drawable.ic_false)){
                result = false;
                break;
            }
        }

        return result;
    }

    public static String changeTimeToString(long time){
        String result = "";
        String strSeconds = "";
        String strMinutes = "";

        strSeconds = (time % 60)+"";
        strMinutes = (time / 60)+"";

        strSeconds = strSeconds.length()==1 ? ("0"+strSeconds): strSeconds;
        strMinutes = strMinutes.length()==1 ? ("0"+strMinutes): strMinutes;

        result = strMinutes+":"+strSeconds;

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
