import java.util.Arrays;

public class LongestIncreasingPathinMatrix {

    public static int LIP(int dp[][], int mat[][], int n, int m, int x, int y) {
        if (dp[x][y] < 0) {
            int result = 0;
            if (x == n-1 && y == m-1) {
                return dp[x][y] = 1;
            }

            if (x == n-1 || y == m-1) {
                result = 1;
            }

            if (x + 1 < n && mat[x][y] < mat[x+1][y]) {
                result = 1 + LIP(dp, mat, n, m, x+1, y);
            }

            if (y+1 < m && mat[x][y] < mat[x][y+1]) {
                result = Math.max(result, 1 + LIP(dp, mat, n, m, x, y+1));
            }

            dp[x][y] = result;
        }

        // printdp(dp);
        return dp[x][y];
    }

    static int wrapper(int mat[][], int n, int m){
        int dp[][] = new int[10][10];

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], -1);
        }
        return LIP(dp, mat, n, m, 0, 0);
    }
        
    public static void printdp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
    
    public static void main(String[] args) {
        int mat[][] = {
                        { 1, 2, 3, 4 },
                        { 2, 2, 3, 4 },
                        { 3, 2, 3, 4 },
                        { 4, 5, 6, 7 }
                    };

        int n = 4, m = 4;
        System.out.println(wrapper(mat, n, m));
    }
}


/*
 * 
 * 
 * Question 4 :
 * Longest Increasing Path in Matrix
 * 
 * We have a matrix of N rows and M columns. From m[i][j], we can move 
 * to m[i+1][j], if m[i+1][j] > m[i][j], or can move to m[i][j+1] 
 * if m[i][j+1] > m[i][j]. The task is to print the longest path length 
 * if we start from (0, 0).
 * 
 * Input : N = 4, M = 4
 * m[][] = { { 1, 2, 3, 4 },
 *           { 2, 2, 3, 4 },
 *           { 3, 2, 3, 4 },
 *           { 4, 5, 6, 7 } };
 * 
 * Output : 7
 * Longest path is 1 2 3 4 5 6 7.
 * 
 * Input : N = 2, M = 2
 * m[][] = { { 1, 2 },
 *           { 3, 4 } };
 * 
 * Output :3
 * Longest path is either 1 2 4 or 1 3 4.
 * 
 * Time Complexity : o(n2)
 * Space Complexity: o(n2)
 * 
 * 
 */