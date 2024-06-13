package GreedyAlgorithms;

public class KthLargestOddNumberInAGivenRange {
    public static  int KthLargestOddNumber(int L, int R, int kth){
        int pos = 0;
        if(kth > L){
            return  0;
        }
        while (L < R){
            if(L%2 != 0){
                pos++;
                if(L == kth){
                    break;
                }
            }
            L++;
        }

        return pos;
    }
    public static void main(String args[]){

        int L = -3, R = 3, kth = 1;


        System.out.println("Kth largest odd number in a given range " +KthLargestOddNumber(L, R, kth));
    }
}
