package Graph;

import java.util.ArrayList;

public class ArticulationPoint {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, boolean vis[], int dt[], int lowT[], int time, boolean ap[]){
        vis[curr] = true;
        dt[curr] = lowT[curr] = ++time;
        int children = 0;

        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(e.dest == par){
                continue;
            }
            else if (!vis[e.dest]){
                dfs(graph, e.dest,e.src, vis, dt, lowT, time,ap);
                lowT[curr] = Math.min(lowT[curr],lowT[e.dest]);
                if (par != -1 && dt[curr] <= lowT[e.dest]){
                    ap[curr] = true;
                }
                children++;
            } else {
                lowT[curr] = Math.min(lowT[curr],dt[e.dest]);
            }
        }
        if (par == -1 && children>1){
            ap[curr] = true;
        }
    }
    public static void getAP(ArrayList<Edge>[] graph, int v){
        int dt[] = new int[v];
        int lowT[] = new int[v];
        boolean vis[] = new boolean[v];
        int time = 0;
        boolean ap[] = new boolean[v];
        for (int i=0; i<v; i++){
            if (!vis[i]){
                dfs(graph,i,-1,vis, dt, lowT,time,ap);
            }
        }
        for (int i=0; i<v; i++){
            if (ap[i]){
                System.out.println("AP "+i);
            }
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        //graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        //graph[4].add(new Edge(4,5));

        //graph[5].add(new Edge(5,3));
        //graph[5].add(new Edge(5,4));
    }
    public static void main(String args[]){
        int v = 6;
        ArrayList<Edge>[] graph = new  ArrayList[v];
        createGraph(graph);
        getAP(graph,v);
    }
}
