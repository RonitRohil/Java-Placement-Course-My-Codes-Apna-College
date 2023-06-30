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
    
    public static void main(String[] args) {
        int V = 7;
        // int E = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(0, 1,adj);
        addEdge(0, 2,adj);
        addEdge(1, 3,adj);
        addEdge(4, 1,adj);
        addEdge(6, 4,adj);
        addEdge(5, 6,adj);
        addEdge(5, 2,adj);
        addEdge(6, 0,adj);
        System.out.println("The mother vertex is " + motherVertex(adj, V));
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
 * 
 */