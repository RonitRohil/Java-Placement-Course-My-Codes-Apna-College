public class LongestCommonSubstring {

    public static int longestcommonsubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

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
                    ans = Math.max(ans, dp[i][j]);
                }

                else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        String s1 = "ABCDE";
        String s2 = "ABGCE";

        System.out.println(longestcommonsubstring(s1, s2));
    }
}


/*
 * 
 * 
 * Longest Common Substring
 * A substring is a contiguous sequence of characters within a string
 * 
 * s1 = "ABCDE", s2 = "ABGCE"
 * ans = 2 //"AB"
 * 
 * s1 = "ABCDGH", s2 = "ACDGHR"
 * ans = 4 //"CDGH"
 * 
 * Time and Space Complexity = O(n*m)
 * 
 * 
 */