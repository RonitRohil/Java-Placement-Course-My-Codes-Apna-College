public class DP {

    public static int fibTabulation(int n) { // O(n)
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 5;
        // int f[] = new int[n+1]; //0 ,0 ,0 , 0
        System.out.println(fibTabulation(n));
    }
}


/*
 * 
 * 
 * Dynamic Programming -> DP
 * It is optimized recusion
 * 
 * How to identify DP?
 * a. Optimal Problem
 * b. Some choice is given (multiple branches in recursion tree)
 * 
 * Dynamic Programming is a technique in computer programming that helps 
 * to efficiently solve a class of problems that have overlapping 
 * subproblems and optimal substructure property.
 * 
 * Ways of DP
 * 1. Memoization (Top Down)
 *    - Recursion
 *    - Subproblems -> Storage
 *    - Stack Overflow can occur
 * 
 * 
 * 
 * 2. Tabulation (Bottom Up)
 *    - Efficient
 *    - Iteration
 * 
 * 7 Important Questions and Concepts
 *  - Fibonacci
 *      -> Climbing Stairs
 *      -> Number Factors
 *      -> Min Jumps to reach the end
 *      -> Min Jumps with cost
 *      -> House thief
 * 
 *  - 0-1 Knapsack
 *      -> Subset Sum
 *      -> Equal Subset Sum partition
 *      -> Min Subset Sum Difference
 *      -> Count of Subset Sum
 *      -> Target Sum
 * 
 *  - Unbounded Knapsack
 *      -> Rod Cutting
 *      -> Coin Change
 *      -> Min Coin Change
 *      -> Max Ribbon Cut
 * 
 *  - LCS (Longest Common Subsequence)
 *      -> Longest Common Substring
 *      -> Edit Distance
 *      -> Box Stacking
 *      -> Longest Increasing Subsequence
 *      -> Longest Bitonic Subsequence
 *      -> Subsequence Pattern Matching
 *      -> Min add/delete to convert one string to another
 * 
 *  - Kadane's Aglorithm (Arrays)
 * 
 *  - Catalan Number
 *      -> No. of BSTs
 *      -> N Parentheses
 *      -> Convex Polygons
 *      -> Disjoint Chords
 *      -> Catalan Traingle
 *      -> Mountain Ranges
 *      -> Dyck Words
 * 
 *  - DP on Grid (2D Arrays)
 * 
 * 
 * 
 */ 