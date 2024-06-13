package Graph;

public class MinimumTimeRequiredToRotAllOranges {
    public static int[][] minimumTime(int orangeBask[][]){
        int row = orangeBask.length;
        int col = orangeBask[0].length;
        for (int i =0; i< row; i++){
            for (int j=0; j<col; j++){
                if (orangeBask[i][j] == 2) {
                    //left
                    if ((j - 1) != -1 && orangeBask[i][j - 1] == 1) {
                        orangeBask[i][j - 1]++;
                    }
                    //right
                    if ((j + 1) != col && orangeBask[i][j + 1] == 1) {
                        orangeBask[i][j + 1]++;
                    }
                    //top
                    if ((i - 1) != -1 && orangeBask[i - 1][j] == 1) {
                        orangeBask[i - 1][j]++;
                    }
                    //bottom
                    if ((i + 1) != row && orangeBask[i + 1][j] == 1) {
                        orangeBask[i + 1][j]++;
                    }
                }
            }
        }
        return orangeBask;
    }
    public static void main(String args[]){
        int orangeBask[][] ={{2, 1, 0, 2, 1},
                         {0, 0, 1, 2, 1},
                         {1, 0, 0, 2, 1}};
        minimumTime(orangeBask);
        //rotOrg(orangeBask);

        for (int i =0; i<orangeBask.length; i++) {
            for (int j = 0; j <orangeBask[0].length; j++) {
                System.out.print(orangeBask[i][j]+" ");
            }
            System.out.println();
        }
    }
}
