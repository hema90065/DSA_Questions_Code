package GreedyAlgorithms;

import java.util.Comparator;
import java.util.*;

public class MaximumActivity {
    public static void main(String args[]){
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = { 2, 4, 6, 7, 9, 9};

        //Sorting
        int activities[][] = new  int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lembda function -> sortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time basic sorted
        int maxAct = 0;
        ArrayList<Integer> a = new ArrayList<>();

        maxAct = 1;
        a.add(activities[0][0]);
        int endActTime = activities[0][2];
        for(int i=1; i<end.length; i++){
            if(activities[i][1]>= endActTime){
                // Activity select
                maxAct++;
                a.add(activities[i][0]);
                endActTime = activities[i][2];
            }
        }

        System.out.println("Maximum Activities = " +maxAct);
        for (int i=0; i<a.size(); i++){
            System.out.print("A"+a.get(i)+ " ");
        }
    }
}
