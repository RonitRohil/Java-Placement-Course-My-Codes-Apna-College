import java.util.*;

public class SortbyFrequency {

    public static String freqSort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.add(e);
        }

        StringBuilder res = new StringBuilder();

        while (pq.size() != 0) {
            char ch = pq.poll().getKey();
            int val = map.get(ch);

            while (val != 0) {
                res.append(ch);
                val--;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "ccccaaaa";
        String t = "tree";

        System.out.println(freqSort(s));
        System.out.println(freqSort(t));
    }
}


/*
 * 
 * 
 * Question 3 :
 * Sort by Frequency
 * 
 * Given a string s, sort it in decreasing order based on the frequency 
 * of the characters. The frequency of a character is the number of
 * times it appears in the string. Return the sorted string. If there
 * are multiple answers, return any of them.
 * 
 * Sample Input 1 : s = "cccaaa"
 * Sample Output 1 : "aaaccc"
 * 
 * Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" 
 * are valid answers.
 * 
 * Note that "cacaca" is incorrect, as the same characters must be 
 * together.
 * 
 * 
 * Sample Input 2 : s = "tree"
 * Sample Output 2 :"eert"
 * 
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also 
 * a valid answer.
 * 
 * 
 * 
 */