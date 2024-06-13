package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static List<int[]> mergeIntervals(int intervals[][]){
        if (intervals.length==0){
            return new ArrayList<>();
        }

        Arrays.sort(intervals, Comparator.comparingInt(i-> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval: intervals) {
            if (interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                result.add((newInterval));
            }
        }
        return result;
    }
    public static void main(String args[]){
        int intervals[][] = {{1,3},{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16,17}};

       List<int[]> result= mergeIntervals(intervals);
        for (int[] interval: result) {
            System.out.println(interval[0]+","+interval[1]);
        }

    }
}
