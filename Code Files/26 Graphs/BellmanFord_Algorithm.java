public class BellmanFord_Algorithm {
    public static void main(String[] args) {
        
    }
}


/*
 * 
 * 
 * Bellman Ford Algorithm
 * Shortest paths from the source to all vertices (negative edges)
 * 
 * In Dijkstra's algorithm -> it can give wrong ans for -ve edges.
 * 
 * It is DP based algorithm.
 * 
 * TIme: O(VE) greater time
 * 
 *  
 *              (-1)
 *         1 <------- 4
 *  (2)   / |         >
 *       /  |         |
 *      0   |         |  (4)
 *       \  |         |
 *  (4)   \ <         |
 *         2 -------> 3
 *              (2)
 * 
 * 
 */