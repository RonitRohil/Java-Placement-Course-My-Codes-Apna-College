public class BalancedParenthesis {

    public static void printParenthesisUtil(char str[], int pos, int n, int open, int close) {
        if (close == n) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
            return;
        }

        else {
            if (open > close) {
                str[pos] = '}';
                printParenthesisUtil(str, pos+1, n, open, close+1); 
            }

            if (open < n) {
                str[pos] = '{';
                printParenthesisUtil(str, pos + 1, n, open + 1, close);
            }
        }
    }

    public static void printParenthesis(char str[], int n) {
        if (n > 0) {
            printParenthesisUtil(str, 0, n, 0, 0);
        }

        return;
    }
    
    public static void main(String[] args) {
        int n = 2;
        char[] str = new char[2*n];
        printParenthesis(str, n);
    }
}


/*
 * 
 * 
 * Question 2 :
 * Print all combinations of balanced parentheses
 * Write a function to generate all possible n pairs of balanced 
 * parentheses.
 * 
 * Input: n = 1
 * Output: {}
 * 
 * Input : n = 2
 * Output: {}{}, {{}}
 * 
 * Time Complexity : o(n)
 * Space Complexity: o(n)
 * 
 * 
 */
