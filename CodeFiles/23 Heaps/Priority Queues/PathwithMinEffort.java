import java.util.PriorityQueue;

public class PathwithMinEffort {

    static int ROW = 5;
    static int COL = 5;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int distance;

        Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    static boolean isInsideGrid(int i, int j) {
        return (i >= 0 && i < ROW && j >= 0 && j < COL);
    }

    static int shortestPath(int[][] grid, int row, int col) {
        int[][] dist = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = grid[0][0];

        PriorityQueue<Cell> pq = new PriorityQueue<>();

        pq.add(new Cell(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();

            for (int i = 0; i < 4; i++) {
                int rows = curr.x + dx[i];
                int cols = curr.y + dy[i];

                if (isInsideGrid(rows, cols)) {
                    if (dist[rows][cols] > dist[curr.x][curr.y] + grid[rows][cols]) {
                        if (dist[rows][cols] != Integer.MAX_VALUE) {
                            Cell adj = new Cell(rows, cols, dist[rows][cols]);
                            pq.remove(adj);
                        }

                        dist[rows][cols] = dist[curr.x][curr.y] + grid[rows][cols];

                        pq.add(new Cell(rows, cols, dist[rows][cols]));
                    }
                }
            }
        }

        return dist[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { 
            { 31, 100, 65, 12, 18 }, 
            { 10, 13, 47, 157, 6 },
            { 100, 113, 174, 11, 33 }, 
            { 88, 124, 41, 20, 140 }, 
            { 99, 32, 111, 41, 20 } 
        };

        System.out.println(shortestPath(grid, ROW, COL));
    }
}


/*
 * 
 * 
 * Question 3 :
 * Path With Minimum Effort
 * 
 * We have a two-dimensional grid, each cell of which contains an 
 * integer cost which represents a cost to traverse through that cell,
 * we need to find a path from the top left cell to the bottom right
 * cell by which the total cost incurred is minimum.
 * 
 * Sample Input 1 :
 *              { 
 *                  { 31, 100, 65, 12, 18 },
 *                  { 10, 13, 47, 157, 6 },
 *                  { 100, 113, 174, 11, 33 },
 *                  { 88, 124, 41, 20, 140 },
 *                  { 99, 32, 111, 41, 20 } 
 *              }
 * 
 * Sample Output 1 : 327 
 *      (= 31 + 10 + 13 + 47 + 65 + 12 + 18 + 6 + 33 + 11 + 20 + 41 + 20)
 * 
 * 
 */