package GreedyAlgorithms;

import java.util.ArrayList;

public class MaxActivity {
    public static void main(String args[]){
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = { 2, 4, 6, 7, 9, 9};

        //end time basic sorted
        int maxAct =0;
        ArrayList<Integer> a = new ArrayList<>();

        //1st Activity
        maxAct = 1;
        a.add(0);
        int endAct = end[0];
        for (int i=1; i<end.length; i++){
            if(start[i] >= endAct){
                //Activity select
                maxAct++;
                a.add(i);
                endAct = end[i];
            }
        }

        System.out.println("Maximum Activities = " +maxAct);
        for (int i=0; i<a.size(); i++){
            System.out.print("A"+a.get(i)+ " ");
        }
    }
}
