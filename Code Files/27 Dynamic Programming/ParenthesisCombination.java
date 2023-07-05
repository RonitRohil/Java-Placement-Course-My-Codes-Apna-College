public class ParenthesisCombination {
    
    public static int helper(int left, int right) {
        int ans = 0;

        if (left == 0 && right == 0){
            ans++;
        }

        if (left > right){
            return 0;
        }

        if (left > 0){
            helper(left-1, right);
        }

        if (right > 0){
            helper(left, right-1);
        }

        return ans;
    }

    // Find possible ways for balanced parentheses
    private static int countWays(int n){
    // If n is odd no possible valid parentheses
        if ((n & 1) != 0) {
            return 0;
        }
        
        return helper(n / 2, n / 2);
    }
        

    public static void main(String[] args) {
        System.out.println(countWays(14));
    }
}

/*
 * 
 * 
 * Question 5 :
 * Number of Parenthesis Combinations
 * Given N number of parenthesis (pair of opening and closing 
 * parenthesis), you have to count all the valid combinations of the 
 * parenthesis.
 * 
 * Input : N = 4
 * Output : 14
 * 
 * //Following 14 combinations
 * 
 * {
 *      (((()))), ((()())), ((())()), ((()))(), (()(())), (()()())
 *      (()())(), (())(()), (())()(), ()((())),()(()()), ()(())()
 *      ()()(()), ()()()()
 * }
 * 
 * 
 */
