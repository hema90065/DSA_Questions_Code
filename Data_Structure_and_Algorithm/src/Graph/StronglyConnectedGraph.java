package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedGraph {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
    }
    public static void topSort(ArrayList<Edge>[] graph, boolean vis[], int curr, Stack<Integer> s){
        vis[curr] = true;

        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                topSort(graph, vis, e.dest, s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge>[] transpose, boolean vis[], int curr){
        vis[curr] = true;
        System.out.print(curr+" ");
        for (int i=0; i<transpose[curr].size(); i++){
             Edge e = transpose[curr].get(i);
             if (!vis[e.dest]){
                 dfs(transpose, vis, e.dest);
             }
        }
        System.out.println();
    }
    public static void kosaraju(ArrayList<Edge>[] graph, int v){
        // step 1 - get node in stack (topological sort)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];
        for (int i=0; i<v; i++){
           if(!vis[i]){
               topSort(graph, vis, i, s);
           }
        }

        // step2 - create transpose graph
        ArrayList<Edge>[] transpose = new  ArrayList[v];
        for (int i=0; i<v; i++){
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for (int i=0; i<v; i++){
            for (int j=0; j<graph[i].size(); i++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step3 - do DFS according to stack node on transpose graph
        while (!s.isEmpty()){
            int curr = s.pop();
            if (!vis[curr]){
                System.out.print("SCC -->");
                dfs(transpose,vis,curr);
                System.out.println();
            }
        }
    }
    public static void main(String args[]){
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        kosaraju(graph,v);
    }
}
