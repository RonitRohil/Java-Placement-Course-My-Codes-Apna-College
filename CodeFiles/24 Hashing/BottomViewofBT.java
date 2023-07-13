import java.util.*;

public class BottomViewofBT {

    static class Node {
        int data;
        int hd;
        Node left, right;
        
        public Node(int key) {
            this.data = key;
            this.hd = Integer.MAX_VALUE;
            this.left = this.right = null;
        }
    }

    public static void bottomViewHelper(Node root, int curr, int head, TreeMap<Integer, int[]> map) {
        if(root == null) {
            return;
        }

        if (!map.containsKey(head)) {
            map.put(head, new int[]{root.data, curr});
        }

        else {
            int[] p = map.get(head);
            if (p[1] <= curr) {
                p[1] = curr;
                p[0] = root.data;
            }

            map.put(head, p);
        }

        bottomViewHelper(root.left, curr + 1, head - 1, map);
        bottomViewHelper(root.right, curr + 1, head + 1, map);
    }
        
    public static void printBottomView(Node root) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        bottomViewHelper(root, 0, 0, map);

        for (int val[] : map.values()) {
            System.out.print(val[0] + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Bottom view of the given binary tree:");

        printBottomView(root);
    }
}

/*
 * 
 * 
 * Question 1 :
 * Bottom View of a Binary Tree
 * 
 * The top view of a binary tree is the set of nodes visible when the 
 * tree is viewed from the top. Given a binary tree, print the top view
 * of it. The output nodes can be printed in any order.
 * 
 * Sample Input :
 * 
 *           20
 *          /  \
 *         8    22
 *        / \     \
 *       5   3     25
 *          / \
 *        10  14
 * 
 * 
 * Sample Output : 5 10 3 14 25
 * Hint : Use the concept of Vertical Order
 * 
 * Solution 1:
 * Using the concept of Horizontal Distance (HD), as discussed in Top 
 * View of a Binary Tree Question in the Trees chapter.
 * 
 * 
 */
