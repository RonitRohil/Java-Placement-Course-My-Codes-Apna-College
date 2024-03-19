import java.util.*;

public class MotherVertex {

    static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj) {
        adj.get(u).add(v);
    }

    static void DFSUtil(ArrayList<ArrayList<Integer>> g, int v, boolean[] visited) {
        visited[v] = true;

        for (int x : g.get(v)) {
            if (!visited[x]) {
                DFSUtil(g, x, visited);
            }
        }
    } 

    static int motherVertex(ArrayList<ArrayList<Integer>> g, int V) {
        boolean[] visited = new boolean[V];
        int v = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(g, i, visited);
                v = i;
            }
        }

        boolean[] check = new boolean[V];
        DFSUtil(g, v, check);

        for (boolean val : check) {
            if (!val) {
                return -1;
            }
        }

        return v;
    }

    // Code For Strongly Connected Component

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }
 
    // O(V + E)
    public static void Kosaraju(ArrayList<Edge> graph[], int V) {
        // Step 1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        // Step 2
        ArrayList<Edge> transpose[] = new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src)); // reverse edge
            }
        }
 
        // Step 3

        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC -> ");
                dfs(transpose, curr, vis); //scc
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(0, 1, adj);
        addEdge(0, 2, adj);
        addEdge(1, 3, adj);
        addEdge(4, 1, adj);
        addEdge(6, 4, adj);
        addEdge(5, 6, adj);
        addEdge(5, 2, adj);
        addEdge(6, 0, adj);
        System.out.println("The mother vertex is " + motherVertex(adj, V));

        /*
         * 
         * 
         * 
         * 
         */

        int V1 = 5;
        ArrayList<Edge> graph[] = new ArrayList[V1];
        createGraph(graph);
        Kosaraju(graph, V1);
    }
}



/*
 * 
 * 
 * Question 1 :
 * Mother Vertex
 * We have a Directed Graph, find a Mother Vertex in the Graph (if 
 * present). A Mother Vertex is a vertex through which we can reach all 
 * the other vertices of the Graph.
 * 
 * Input :
 *              1 -----------> 0 ----------> 3 --------> 4
 *              ^             /              
 *               \           / 
 *                \         /   
 *                 \       /
 *                  \     /
 *                   \   <
 *                     2            
 * 
 * Output : 0
 * 
 * Time Complexity : o(v+e)
 * Space Complexity: o(v+e)
 * 
 * Same as above question
 * 
 * Strongly Connected Component
 * SCC is a componenet in which we can reach every vertex of the 
 * component from every other vertex in that component.
 * 
 * Only for Directed Graphs
 * 
 * - Kosaraju's Algorithm
 * 
 * a. Get nodes in stack (topological sort)
 * b. Transpose the graph
 * c. Do DFS according to stack nodes on the transpose graph
 * 
 * 
 */