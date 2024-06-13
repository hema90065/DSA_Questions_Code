package Arrays;
import java.util.*;

public class LinearSearch {
    public static int linearSearch(int numbers[], int key){
        for (int i=0; i<=numbers.length; i++){
            if(numbers[i] == key){
                return 1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int numbers[] = {1, 2, 6, 3, 5};
        int key = 5;
        int found = linearSearch(numbers, key);

        if (found == 1){
            System.out.print("Key Found");
        } else {
            System.out.print("Key Not Found");
        }
    }
}
