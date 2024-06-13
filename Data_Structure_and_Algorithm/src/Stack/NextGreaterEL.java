package Stack;

import java.util.Stack;

public class NextGreaterEL {
    public static void main(String args[]){
        //int arr[] = {6, 8, 0, 1, 3};
        int arr[] = {2, 4, 10, 5, 15, 3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for(int i = arr.length-1; i>=0; i--){  //TC = O(N)
            //1 while loop remove smaller element
            while(!s.isEmpty() && arr[s.peek()]<= arr[i]){
                s.pop();
            }

            //2 if-else
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }
            //3 push in stack
            s.push(i);
        }

        for (int i=0; i<nextGreater.length; i++){
            System.out.print(nextGreater[i]+ " ");
        }

        //next Greater Right
        //next Greater Left
        //next smaller Right
        //next smaller left
    }
}
