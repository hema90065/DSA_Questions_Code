package Graph;

public class FloodFillAlgorithm {
    public static void helper(int image[][], int sr, int sc, int color,int orgcol){

        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length  || image[sr][sc] != orgcol){
            return;
        }
        image[sr][sc] = color;
        //left
        helper(image,sr,sc-1,color,orgcol);
        //right
        helper(image,sr,sc+1,color,orgcol);
        //up
        helper(image,sr-1,sc,color,orgcol);
        //down
        helper(image,sr+1,sc,color,orgcol);

    }
    public static int[][] floodFill(int image[][], int sr, int sc, int color){
        helper(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public static void main(String args[]){
        int image [][] ={{1,1,1},
                         {1,1,0},
                         {1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int[][] changeImage = floodFill(image,sr,sc,color);

        for (int i=0; i< image.length; i++){
            for (int j=0; j< image[0].length; j++){
                System.out.print(changeImage[i][j]);
            }
            System.out.println();
        }
    }

}
