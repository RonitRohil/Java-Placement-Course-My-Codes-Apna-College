class Node {
    int data;
    Node left, right;
    
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Res {
    public int val;
}


public class MaxPathSuminBT {
    
    Node root;

    int findMaxUtil(Node node, Res res) {
        if (node == null) {
            return 0;
        }

        int left = findMaxUtil(node.left, res);
        int right = findMaxUtil(node.right, res);

        int max_single = Math.max(Math.max(left, right) + node.data, node.data);

        int max_top = Math.max(max_single, left + right + node.data);

        res.val = Math.max(res.val, max_top);

        return max_single;
    }

    int findMaxSum() {
        return findMaxSum(root);
    }

    int findMaxSum(Node node) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        findMaxUtil(node, res);
        return res.val;
    }

    public static void main(String[] args) {
        MaxPathSuminBT tree = new MaxPathSuminBT();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " + tree.findMaxSum());
    }
}


/*
 * 
 * Question 5 :
 * Maximum Path Sum in a Binary Tree
 * 
 * We have a binary tree, find the maximum path sum. The path may start 
 * and end at any node in the tree.
 * 
 * Input1:
 *          4
 *         / \
 *        2   7
 * 
 * Output1: 1 3
 * 
 * Input2:  
 *          -10
 *          / \
 *         9  20
 *            / \
 *           15  7
 * 
 * Output: 42
 * 
 * Time Complexity : o(n)
 * Space Complexity: o(1)
 * 
 * 
 */