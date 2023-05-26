public class KnightTour {

    static int N = 8;

    public static boolean isSafe(int x, int y, int sol[][])
    {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }
    

    public static void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }

            System.out.println();
        }
    }

    /**
     * @return
     */
    public static boolean solveKightTour()
    {
        int sol[][] = new int[8][8];

        for(int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        
        sol[0][0] = 0;

        if(!solveKT(0, 0, 1, sol, xMove, yMove))
        {
            System.out.println("Solution does not exist");
            return false;
        }

        else
        {
            printSolution(sol);
        }

        return true;
    }

    public static boolean solveKT(int x, int y, int move, int sol[][], int xMove[], int yMove[])
    {
        int k, next_x, next_y;

        if(move == N*N)
        {
            return true;
        }

        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];

            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = move;

                if (solveKT(next_x, next_y, move + 1, sol, xMove, yMove)) {
                    return true;
                }

                else
                {
                    sol[next_x][next_y] = -1; //backtracking
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        solveKightTour();
    }
}


/*
 * 
 * 
 * Knight’s Tour
 * Given a N*N board with the Knight placed on the first
 * block of an empty board. Moving according to the rules 
 * of chess, knights must visit each square exactly once. 
 * Print the order of each cell in which they are visited.
 * 
 * Sample Input 1 : N = 8
 * Sample Output 1 : 0 59 38 33 30 17 8 63
 *                   37 34 31 60 9 62 29 16
 *                   58 1 36 39 32 27 18 7
 *                   35 48 41 26 61 10 15 28
 *                   42 57 2 49 40 23 6 19
 *                   47 50 45 54 25 20 11 14
 *                   56 43 52 3 22 13 24 5
 *                   51 46 55 44 53 4 21 12
 * 
 * 
 * (Hint : Similar to N Queens)
 * 
 * 
 */