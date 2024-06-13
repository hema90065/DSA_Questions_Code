package Graph;

public class FloydWarshallAlgorithm {
    static int INF = 99999;
    public static void shortestDist(int graph[][]){
        int dist[][] = new int[graph.length][graph[0].length];
        for (int i=0; i< graph.length; i++){
            for (int j=0; j<graph[0].length; j++){
                dist[i][j] = graph[i][j];
            }
        }
        for (int k=0; k<graph.length; k++){
            for (int i=0; i< graph.length; i++){
                for (int j=0; j<graph[0].length; j++){
                    if(dist[i][k] + dist[k][j]<graph[i][j]){
                        graph[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int graph[][] = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}};
        shortestDist(graph);
        for (int i=0; i< graph.length; i++){
            for (int j=0; j<graph[0].length; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
