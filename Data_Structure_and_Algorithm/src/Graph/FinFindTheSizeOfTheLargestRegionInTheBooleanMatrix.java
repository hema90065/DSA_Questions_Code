package Graph;

public class FinFindTheSizeOfTheLargestRegionInTheBooleanMatrix {
    public static int getRegionSize(int matrix[][], int i, int j){
        if(i<0 || j<0 || i>= matrix.length || j>=matrix[0].length){
            return 0;
        }
        if(matrix[i][j] == 0){
            return 0;
        }
        int size = 1;
        matrix[i][j] = 0;
        for (int row=i-1; row<=i+1; row++){
            for (int col=j-1; col<=j+1; col++){
                if(row != i || col != j){
                   size += getRegionSize(matrix, row, col);
                }
            }
        }
        return size;
    }
    public static int getLargestRegion(int matrix[][]){
        int largestRegion = 0;
        for (int i=0; i< matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j]==1){
                    int size = getRegionSize(matrix,i,j);
                    largestRegion = Math.max(largestRegion, size);
                }
            }
        }
        return largestRegion;
    }
    public static void main(String args[]){
        int matrix[][] = { { 0, 0, 1, 1, 0 },
                           { 1, 0, 1, 1, 0 },
                           { 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 1 } };
        System.out.println(getLargestRegion(matrix));
    }
}
