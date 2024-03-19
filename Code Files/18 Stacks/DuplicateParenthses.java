import java.util.*;

public class DuplicateParenthses {

    public static boolean isValid(String str)
    {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }

            else
            {
                //Closing
                if (s.isEmpty()) {
                    return false;
                }

                if ((s.peek() == '(' && ch == ')')
                    || (s.peek() == '{' && ch == '}')
                    || (s.peek() == '[' && ch == ']')) 
                    {
                        s.pop();
                }

                else
                {
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;
        }

        else
        {
            return false;
        }
    }

    public static boolean isDuplicate(String str)
    {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true; // 
                }
                
                else{
                    s.pop(); // opening pair
                }
            }

            else
            {
                //opening
                s.push(ch);
            }
        }

        return false;
    }

    
    public static void main(String[] args) {
        String str = "((a+b))";
        String str2 = "(a-b)";
        System.out.println(isValid(str));
        System.out.println(isDuplicate(str));
        System.out.println(isValid(str2));
        System.out.println(isDuplicate(str2));
    }
}



/*
 * 
 * Given a balanced expression, find if it contains duplicate parentheses
 * or not. A set of parentheses are duplicate if the same subexpression
 * id surrounded by multiple parentheses.
 * 
 * Return a true if it contains duplicates else return false.
 * 
 * example: (((a + (b))) + (c+ d)) -> true
 * example: ((((a) + (b)) + c + d )) -> true
 * example: ((a + b) + (c + d )) -> false
 * example: (((a + b)) + c) -> true
 * 
 */
