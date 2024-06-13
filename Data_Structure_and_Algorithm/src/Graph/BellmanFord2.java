package Graph;

import java.util.ArrayList;

public class BellmanFord2 {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph){
        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));

        graph.add(new Edge(1,2 ,-4));

        graph.add(new Edge(2,3,2));

        graph.add(new Edge(3,4,4));

        graph.add(new Edge(4,1,-1));
    }
    public static void bellmanFord(ArrayList<Edge> graph, int src, int V){
        int dict[] = new int[V];
        for (int i=0; i< dict.length; i++){
            if(i != src){
                dict[i] = Integer.MAX_VALUE;
            }
        }
        // O(V*E)
        for (int i=0; i<V-1; i++){  // O(v)

            for (int j=0; j<graph.size(); j++){ // O(E)
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                // relaxation
                if (dict[u] != Integer.MAX_VALUE && dict[u]+wt < dict[v]){
                    dict[v] = dict[u]+wt;
                }
            }
        }

        // print
        for (int i=0; i< dict.length; i++){
            System.out.print(dict[i]+" ");
        }
    }
    public static void main(String args[]){
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        bellmanFord(graph,0,V);
    }
}
