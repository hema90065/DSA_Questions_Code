package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
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
    public static void createGraph(ArrayList<Edge>[] graph, int flight[][]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i< flight.length; i++){
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];

            Edge e = new Edge(src,dest,wt);
            graph[src].add(e);
        }
    }
    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v, int c, int s){
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }
    public static int cheapestFlightsWithinKStops(int n, int flight[][], int src, int dest, int k){
        ArrayList<Edge>[] graph = new ArrayList[flight.length];
        createGraph(graph, flight);

        int dist[] = new int[graph.length];
        for (int i=0; i< graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()){
            Info curr = q.remove();

            if (curr.stops > k){
                break;
            }

            for (int i=0; i<graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int w = e.wt;
//                if (dist[u] != Integer.MAX_VALUE && dist[u]+w < dist[v] && curr .stops <= k){
//                    dist[v] = dist[u]+w;
//                    q.add(new Info(v,dist[v],curr.stops+1));
//                }

                if (curr.cost+w < dist[v] && curr .stops <= k){
                    dist[v] = curr.cost+w;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }
        // dist[dest]
        if (dist[dest] == Integer.MAX_VALUE){
            return -1;
        } else {
           return dist[dest];
        }
    }
    public static void main(String args[]){
        int n = 4;
        int flight[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;

        System.out.println(cheapestFlightsWithinKStops(n,flight,src, dst,k));
    }
}
