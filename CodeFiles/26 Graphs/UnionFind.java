public class UnionFind {

    int V, E;
    Edge edge[];

    class Edge {
        int src;
        int dest;
    }

    UnionFind(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];

        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    int find(int parent[], int i) {
        if (parent[i] == i) {
            return i;
        }

        return find(parent, parent[i]);
    }

    void Union(int parent[], int x, int y) {
        parent[x] = y;
    }

    int isCycle(UnionFind graph) {
        int parent[] = new int[graph.V];

        for (int i = 0; i < graph.V; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < graph.V; i++) {
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);

            if (x == y) {
                return 1;
            }

            graph.Union(parent, x, y);
        }

        return 0;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        UnionFind graph = new UnionFind(V, E);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
        
        if (graph.isCycle(graph) == 1) {
            System.out.println("Graph contains cycle");
        }

        else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}


/*
 * 
 * 
 * Question 2 :
 * Union-Find
 * Here implement Union-Find Algorithm to check whether an undirected 
 * graph contains cycle or not.
 * 
 * Sample Input 1 :
 *      9 --------- 5 ------- 2
 *      |          /          |
 *      |         /           7
 *      |        /
 *      |       /
 *      |      /    
 *      |     /
 *      |    /
 *      |   /
 *      |  /
 *      | /
 *      1  
 * 
 * Sample Output 1 : Yes
 * 
 * Time Complexity : o(v+e)
 * Space Complexity: o(1)
 * 
 * 
 */