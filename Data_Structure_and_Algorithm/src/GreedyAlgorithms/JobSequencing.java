package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.*;

public class JobSequencing {
    static class Job{
        int deadline;
        int profit;
        int id;
        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String args[]){
        int jobInfo[][] ={{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> job = new ArrayList<>();

        for (int i=0; i<jobInfo.length; i++){
            job.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(job, (obj1, obj2) -> obj2.profit - obj1.profit);
        //descending order of profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for (int i=0; i< jobInfo.length; i++){
            Job curr = job.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max Job = "+ seq.size());

        for (int i=0; i< seq.size(); i++){
            System.out.print(seq.get(i) + " ");
        }
    }
}