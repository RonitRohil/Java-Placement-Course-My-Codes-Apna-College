public class MountainRanges {

    public static int mountainranges(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < n+1; i++) {
            // i pairs -> mountain ranges => Ci
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside;
            }
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 4;
        System.out.println(mountainranges(n));
    }
}

/*
 * 
 * 
 * Mountain Ranges
 * Mountains and Valleys
 * At any moment the number of down strokes cannot be more than number 
 * of up strokes
 * 
 * Up Stroke -> /
 * Down Stroke -> \
 * 
 * Pair = 3
 * ans =    
 *      1.  /\/\/\
 * 
 *      2.   /\
 *          /  \/\
 * 
 *      3.      /\
 *           /\/  \
 * 
 *      4.   /\
 *          /  \
 *         /    \
 * 
 *      5.  /\/\
 *         /    \
 * 
 */