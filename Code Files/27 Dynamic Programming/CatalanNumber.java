import java.util.Arrays;

public class CatalanNumber {

    // Recursion
    public static int catalan(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i <= n-1; i++) {
            ans += catalan(i)*catalan(n-i-1);
        }

        return ans;
    }

    // Memoization
    public static int catalan_memo(int n, int dp[]){
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i <= n-1; i++) {
            ans += catalan_memo(i, dp)*catalan_memo(n-i-1, dp);
        }

        return dp[n] = ans;
    }

    // Tabulation - O(n^2)
    public static int catalan_Tab(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(catalan(n));
        System.out.println(catalan_memo(n, dp));
        System.out.println(catalan_Tab(n));
    }
}

/*
 * 
 * 
 * Catalan's Number
 * C0 = 1
 * C1 = 1
 * C2 = C0.C1 + C1.C0 = 2
 * C3 = C0.C2 + C1.C1 + C2.C0 = 5
 * C4 = C0.C3 + C1.C2 + C2.C1 + C3.C0 = 14
 * 
 * C0 -> C1 -> C2 -> C3 -> C4 -> C5 -> -----
 *  1 ->  1 ->  2 ->  5 -> 14 -> 42 -> -----
 * 
 * Cn = C0.Cn-1 + C1.Cn-2 + C2.Cn-3 + ----- + Cn-1.C0
 * 
 * 
 */
