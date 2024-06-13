package Arrays;

public class LargestElement {
    public static int largest(int numbers[]){
        int largest = Integer.MIN_VALUE;
        for (int i=0; i<numbers.length; i++){
            largest = Math.max(largest, numbers[i]);
        }
        return largest;
    }
    public static void main(String args[]) {
        int numbers[] = {1, 2, 6, 3, 5};
        System.out.println(largest(numbers));
    }
}
