public class RatinMaze {

    public static boolean isSafe(int maze[][], int x, int y)
    {
        int n = maze.length;
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1);
    }
    

    public static boolean SolveMaze(int maze[][])
    {
        int n = maze.length;
        int sol[][] = new int[n][n];

        if(solveMazehelper(maze, 0, 0, sol) == false)
        {
            System.out.println("Solution Does not exists");
            return false;
        }

        printMaze(sol);
        return true;
    }

    public static boolean solveMazehelper(int maze[][], int x, int y, int sol[][])
    {
        int n = maze.length;

        if(x == n - 1 && y == n - 1 && maze[x][y] == 1)
        {
            sol[x][y] = 1;
            return true;
        }

        if(isSafe(maze, x, y))
        {
            if(sol[x][y] == 1)
            {
                return false;
            }

            sol[x][y] = 1;

            if (solveMazehelper(maze, x + 1, y, sol)) {
                return true;
            }

            if (solveMazehelper(maze, x, y + 1, sol)) {
                return true;
            }

            sol[x][y] = 0;
            return false;
        }

        return false;
    }


    public static void printMaze(int maze[][])
    {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 0 },
                        { 1, 1, 1, 1 } };

        // System.out.println(mazePaths(maze));
        SolveMaze(maze);
    }
}


/*
 * 
 * You are given a starting position for a rat which is 
 * stuck in a maze at an initial point (0, 0) (the maze 
 * can be thought of as a 2-dimensional plane). The maze
 * would be given in the form of a square matrix of 
 * order N * N where the cells with value 0 represent the
 * maze’s blocked locations while value 1 is the 
 * open/available path that the rat can take to reach its 
 * destination. The rat's destination is at (N - 1, N - 1).
 * Your task is to find all the possible paths that the 
 * rat can take to reach from source to destination in 
 * the maze. The possible directions that it can take 
 * to move in the maze are 'U'(up) i.e. (x, y - 1) , 'D'(down) 
 * i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 
 * 'R' (right) i.e. (x + 1, y). (This problem is similar to 
 * Grid ways.)  
 * 
 * 
 * Sample Input : int maze[][] = { { 1, 0, 0, 0 },
*                                  { 1, 1, 0, 1 },
 *                                 { 0, 1, 0, 0 },
 *                                 { 1, 1, 1, 1 } };
 * 
 * Sample Output : 1 0 0 0
 *                 1 1 0 0
 *                 0 1 0 0
 *                 0 1 1 1
 * 
 */