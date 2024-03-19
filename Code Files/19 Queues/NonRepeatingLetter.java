import java.util.*;
import java.util.LinkedList;

public class NonRepeatingLetter {
    
    public static void printNonRepeating(String str)
    {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            }

            else
            {
                System.out.print(q.peek() + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}


/*
 * 
 * First non repeating letter in a stream of characters
 * 
 * a a b c c x b
 * 
 * a
 * -1
 * b
 * b
 * b
 * b
 * x - first non repeating letter
 * 
 * output = a -1 b b b b x
 * 
 * Assumption all characters are smallcase
 * 
 * creating a array count[26]
 * aur freq[26] = []
 * 
 */