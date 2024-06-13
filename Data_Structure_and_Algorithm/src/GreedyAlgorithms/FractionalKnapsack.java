package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String arg[]){
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int capacity = 50;

        double ratio[][] = new double[val.length][2];
        // 0th = idx and 1st = ratio

        for (int i=0; i<val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        //Ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int finalVal = 0;
        for(int i= ratio.length-1; i>=0; i--){ // including full item
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                finalVal+=val[idx];
                capacity -= weight[idx];
            } else {
                // include Fractional item
                finalVal += capacity * ratio[i][1];
                capacity = 0;
                break;
            }
        }

        System.out.println("Final Value = " +finalVal);
    }
}
