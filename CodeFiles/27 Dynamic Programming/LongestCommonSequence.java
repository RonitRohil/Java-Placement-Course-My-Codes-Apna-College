public class LongestCommonSequence {

    public static int lcs(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            // same
            return lcs(str1, str2, n - 1, m - 1) + 1;
        } 
        
        else {
            // different
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);

            return Math.max(ans1, ans2);
        }
    }

    // lcs - Memoization Code
    public static int lcs_memo(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            // same
            return dp[n][m] = lcs_memo(str1, str2, n - 1, m - 1, dp) + 1;
        } 
        
        else {
            // different
            int ans1 = lcs_memo(str1, str2, n - 1, m, dp);
            int ans2 = lcs_memo(str1, str2, n, m - 1, dp);

            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    // lcs - tabulation
    public static int lcs_tab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n+1; i++) { 
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }

                else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        System.out.println(lcs_memo(str1, str2, str1.length(), str2.length(), dp));
        System.out.println(lcs_tab(str1, str2));
    }
}


/*
 * 
 * 
 *  Longest Common Subsequence
 *  A subsequence of string is a new string generated from the original 
 *  string with some characters (can be none) deleted without changing 
 *  the relative order of the remaining characters.
 * 
 * str1 = "abcde", str2 = "ace"
 * ans = 3 // "ace"
 * 
 * str1 = "abcdge", str2 = "abedg"
 * ans = 4 // "abdg"
 * 
 * 
 */