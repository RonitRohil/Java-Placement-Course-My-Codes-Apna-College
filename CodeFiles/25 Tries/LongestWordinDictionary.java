public class LongestWordinDictionary {
    
    private static class Node {
        private char data;
        private String word;
        private boolean isEnd;
        private Node[] children;

        public Node(char data) {
            this.data = data;
            this.word = null;
            this.isEnd = false;
            this.children = new Node[26];
        }
    }

    private static Node root = new Node('/');
    private static String ans = "";

    private static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            
            if (curr.children[childIdx] == null) {
                curr.children[childIdx] = new Node(word.charAt(i));
            }
            
            curr = curr.children[childIdx];
        }

        curr.isEnd = true;
        curr.word = word;
    }

    private static void dfs(Node node) {
        if (node == null) {
            return;
        }

        if (node.word != null) {
            if (node.word.length() > ans.length()) {
                ans = node.word;
            } 
            
            else if (node.word.length() == ans.length() && node.word.compareTo(ans) < 0) {
                ans = node.word;
            }
        }

        for (Node child : node.children) {
            if (child != null && child.word != null) {
                dfs(child);
            }
        }
    }
    
    public static String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }

        Node curr = root;
        dfs(curr);

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl","world"};
        
        System.out.println(longestWord(words));
    }
}


/*
 * 
 * 
 * Question 2 : MEDIUM
 * Longest Word in Dictionary
 * 
 * Given an array of strings words representing an English Dictionary, 
 * return the longest word in words that can be built one character at a 
 * time by other words in words.
 * 
 * If there is more than one possible answer, return the longest word 
 * with the smallest lexicographical order. If there is no answer, 
 * return the empty string.
 * 
 * Note that the word should be built from left to right with each 
 * additional character being added to the end of a previous word.
 * 
 * Sample Input 1 : words = ["w","wo","wor","worl","world"]
 * Sample Output 1 : "world"
 * 
 * The word "world" can be built one character at a time by 
 * "w", "wo", "wor", and "worl".
 * 
 * Sample Input 2 : 
 * words = ["a","banana","app","appl","ap","apply","apple"]
 * Sample Output 2 : "apple"
 * 
 * Both "apply" and "apple" can be built from other words in the 
 * dictionary. However, "apple" is lexicographically smaller than 
 * "apply". 
 * 
 * 
 */