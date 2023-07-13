import java.util.Arrays;

public class MatrixChainMultiplication {

    // Recursion
    public static int mcm_recursion(int arr[], int i, int j){
        if (i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost1 = mcm_recursion(arr, i, k);
            int cost2 = mcm_recursion(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];

            int final_cost = cost1 + cost2 + cost3;

            ans = Math.min(ans, final_cost);
        }

        return ans;
    }

    // Memoization
    public static int mcm_memo(int arr[], int i, int j, int dp[][]){
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost1 = mcm_memo(arr, i, k, dp);
            int cost2 = mcm_memo(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];

            int final_cost = cost1 + cost2 + cost3;

            ans = Math.min(ans, final_cost);
        }

        return dp[i][j] = ans;
    }

    // Tabulation - traverse diagonally
    public static int mcm_tab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        
        // initialization
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // bottom-up
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1; //col
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }

        printdp(dp);
        return dp[1][n-1];
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
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(mcm_recursion(arr, 1, n - 1));
        System.out.println(mcm_memo(arr, 1, n-1, dp));
        System.out.println(mcm_tab(arr));
    }
}


/*
 * 
 * 
 * Matrix Basics
 *  A.B
 *  A = a * b
 *  B = c * d
 * 
 * For multiplication 
 *  - b == c
 *  - result matrix = a*d
 * 
 * Matrix Chain Multiplication
 * arr[] = 1, 2, 3, 4, 3
 * Find min cost
 * 
 *  => Arr represents n-1 matrices
 *  A   B   C   D
 * 1*2  2*3 3*4 4*3
 * 
 * Cost = a*b*d
 * 
 * three variables
 *  - i => starting point
 *  - j => ending point
 *  - k => stat -> end
 * 
 * Ai = arr[i-1]*arr[i]
 * A1 = arr[0]*arr[1] = 1*2
 * 
 * memo = recursion + table
 * tab  = iteration + table
 * 
 * 
 */