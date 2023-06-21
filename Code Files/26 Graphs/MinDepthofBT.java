import java.util.*;
import java.util.LinkedList;

public class MinDepthofBT {

    static class Node {
        int data;
        Node left, right;
    }

    static class qItem {
        Node node;
        int depth;

        public qItem(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }
        
    static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<qItem> q = new LinkedList<>();
        qItem qi = new qItem(root, 1);
        q.add(qi);

        while (!q.isEmpty()) {
            qi = q.peek();
            q.remove();
            Node node = qi.node;
            int depth = qi.depth;

            if (node.left == null && node.right == null) {
                return depth;
            }

            if (node.left != null) {
                qi.node = node.left;
                qi.depth = depth + 1;
                q.add(qi);
            }

            if (node.right != null) {
                qi.node = node.right;
                qi.depth = depth + 1;
                q.add(qi);
            }
        }

        return 0;
    }
        
    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        System.out.println(minDepth(root));
    }
}


/*
 * 
 * 
 * Question 2 :
 * Find Minimum Depth of a Binary Tree
 * 
 * We have a binary tree, find its minimum depth. The minimum depth is 
 * the number of nodes along the shortest path from the root node down 
 * to the nearest leaf node. For example, minimum height of below Binary
 * Tree is 2.
 * 
 * Sample Input 1 :
 *                 1
 *                / \
 *               8   2
 *              / \  /
 *             6   5 9
 * 
 * Sample Output 1 : 2
 * 
 * Time Complexity : o(n)
 * Space Complexity: o(1)
 * 
 * 
 */