package Stack;

import java.util.Stack;

public class TrappedRainWater {
    public static int trappedRainWater(int height[]){
        Stack<Integer> s = new Stack<>();
        int n = height.length, trapWater = 0;
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && height[s.peek()] < height[i]){
                int curr = s.peek();
                s.pop();
                if(s.isEmpty()){
                    break;
                }
                int diff = i - s.peek() - 1;
                trapWater += (Math.min(height[s.peek()],height[i]) - height[curr]) * diff;
                //System.out.println(trapWater);
            }
            s.push(i);
        }
        return  trapWater;
    }
    public static void main(String args[]){
        int height [] = { 4, 2, 0, 6, 3, 2, 5};

        System.out.println(trappedRainWater(height));
    }

}
