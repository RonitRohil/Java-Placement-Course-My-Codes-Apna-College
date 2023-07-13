public class FloydWarshallAglo {
    final static int INF = 99999, V = 4;

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int dist[][]){
        System.out.println("The following matrix shows the shortest distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                }

                else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 5, INF, 10 },
                          { INF, 0, 3, INF },
                          { INF, INF, 0, 1 },
                          { INF, INF, INF, 0 } };

        FloydWarshallAglo a = new FloydWarshallAglo();
        a.floydWarshall(graph);
    }
}


/*
 * 
 * 
 * Floyd Warshall Algorithm
 * 
 * Floyd-Warshall Algorithm is an algorithm for finding the shortest 
 * path between all the pairs of vertices in a weighted graph. This 
 * algorithm works for both the directed and undirected weighted graphs. 
 * But, it does not work for the graphs with negative cycles (where the 
 * sum of the edges in a cycle is negative).
 * 
 * Input: graph[][] = { {0, 5, INF, 10},
 *                      {INF, 0, 3, INF},
 *                      {INF, INF, 0, 1},
 *                      {INF, INF, INF, 0} }
 * 
 * which represents the following graph
 *              10
 *          (0)——->(3)
 *           |     /|\
 *         5 |      | 1
 *           |      |
 *          \|/     |
 *          (1)——->(2)
 *              3
 * 
 * Output: Shortest distance matrix
 *      0   5   8   9
 *      INF 0   3   4
 *      INF INF 0   1
 *      INF INF INF 0
 * 
 * Floyd Warshall Algorithm:
 * ● Initialize the solution matrix same as the input graph matrix as a 
 *   first step.
 * ● Then update the solution matrix by considering all vertices as an
 *   intermediate vertex.
 * ● The idea is to one by one pick all vertices and updates all 
 *   shortest paths which include the picked vertex as an intermediate 
 *   vertex in the shortest path.
 * ● When we pick vertex number k as an intermediate vertex, we already 
 *   have considered vertices {0, 1, 2, .. k-1} as intermediate 
 *   vertices. 
 * ● For every pair (i, j) of the source and destination vertices 
 *   respectively, there are two possible cases.
 *      ○ k is not an intermediate vertex in shortest path from i to j. 
 *        We keep the value of dist[i][j] as it is.
 *      ○ k is an intermediate vertex in shortest path from i to j. We 
 *        update the value of dist[i][j] as dist[i][k] + dist[k][j] if 
 *        dist[i][j] > dist[i][k] + dist[k][j]
 * 
 * 
 * 
 */