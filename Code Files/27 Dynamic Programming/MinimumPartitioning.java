public class MinimumPartitioning {

    public static int minDiff(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int W = sum/2;
        int dp[][] = new int[n+1][W+1];

        // bottom Up
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if (arr[i-1] <= j) {
                    //valid
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }

                else {
                    // invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }
    
    public static void main(String[] args) {
        int numbers[] = {1, 6, 11, 5};
        System.out.println(minDiff(numbers));
    }
}

/*
 * 
 * 
 * Minimum Partitioning - Minimum Subset Sum Difference
 * numbers[] = {1, 6, 11, 5}
 * min_diff = 1
 * 
 *  -> 
 *  {1, 6} = 7 {11, 5} = 16 ; => diff = 9
 *  {1, 5} = 6 {11, 6} = 17 ; => diff = 11
 *  {1, 11} = 12 {6, 5} = 11 ; => diff = 1 {ans}
 * 
 * 
 */
