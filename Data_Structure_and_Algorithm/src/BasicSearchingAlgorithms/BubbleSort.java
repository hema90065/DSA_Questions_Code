package BasicSearchingAlgorithms;

public class BubbleSort {
    public static void bubbleSort(int arr[]){
        for (int turn=0; turn<arr.length-1; turn++){
            for (int j=0; j<arr.length-1-turn; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {2, 1, 5, 4, 3};
        bubbleSort(arr);

        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
