import java.util.*;

public class AlienDictionary {

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String result = "";

        if (words == null || words.length == 0) {
            return result;
        }

        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int min = Math.min(curr.length(), next.length());

            for (int j = 0; j < min; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);

                if (c1 != c2) {
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());

                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1); // update c2, c1 < c2
                    }

                    break;
                }
            }
        }

        LinkedList<Character> q = new LinkedList<>();

        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                q.add(c);
            }
        }

        while (!q.isEmpty()) {
            char c = q.poll();
            result += c;

            if (map.containsKey(c)) {
                for (char next : map.get(c)) {
                    degree.put(next, degree.get(next) - 1);
                    if (degree.get(next) == 0) {
                        q.offer(next);
                    }
                }
            }
        }

        return result.length() == degree.size() ? result : "";
    } 


    public static void main(String[] args) {
        String[] dict = {"caa","aaa","aab"};
        System.out.println(alienOrder(dict));
    }
}


/*
 * 
 * 
 * Question 4 :
 * Alien Dictionary
 * 
 * We have a sorted dictionary of an alien language having N words and k
 * starting alphabets of standard dictionary. Find the order of 
 * characters in the alien language. Many orders may be possible for a 
 * particular test case, thus you may return any valid order and output 
 * will be 1 if the order of string returned by the function is correct 
 * else 0 denoting incorrect string returned.
 * 
 * Sample Input 1 :
 * N = 3, K = 3
 * dict = {"caa","aaa","aab"}
 * 
 * Sample Output 1 : 1
 * 
 * Sample Input 2 :
 * N = 5, K = 4
 * dict = {"baa","abcd","abca","cab","cad"}
 * 
 * Sample Output 2 : 1
 * 
 * Time Complexity : o(v+e)
 * Space Complexity: o(v+e)
 * 
 * 
 */