import java.util.Arrays;

public class ClimbingStairs {

    // Recursion - O(2^n) -> n = 10^5
    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        return countWays(n-1) + countWays(n-2);
    }

    // Memoization - O(n)
    public static int countWaysMemoization(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) {
            return ways[n];
        }

        ways[n] = countWaysMemoization(n-1, ways) + countWaysMemoization(n-2, ways);

        return ways[n];
    }

    // Tabulation - O(n)
    public static int countWaysTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            }

            else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 5; // n = 3 -> 3 & n = 4 -> 5 => 8
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(n));
        System.out.println(countWaysMemoization(n, ways));
        System.out.println(countWaysTab(n));
    }
}


/*
 * 
 * 
 * Climbing Stairs
 * Count ways to reach the nth stair. The person can climb either 1 
 * stair or 2 stairs at a time.
 * 
 * - Recursion
 *      ways[n] = ways[n-2] + way[n-1]
 * 
 * - Recursion + Memo
 *      ways[] = 
 * 
 * - Tabulation
 *      1. Create table + initialize
 *      2. Meaning for index
 *      3. fill (small to large)
 * 
 * 
 */