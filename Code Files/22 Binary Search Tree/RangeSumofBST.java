import java.util.LinkedList;
import java.util.Queue;

public class RangeSumofBST {

    static class Node{
        int val;
        Node left, right;
    };


    static Node newNode(int item){
        Node temp = new Node();
        temp.val = item;
        temp.left = temp.right = null;
        return temp;
    }

    static int sum = 0;


    static int rangeSumBST(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.isEmpty() == false) {
            Node curr = q.peek();
            q.remove();

            if (curr.val >= low && curr.val <= high) {
                sum += curr.val;
            }

            if (curr.left != null && curr.val > low) {
                q.add(curr.left);
            }

            if (curr.right != null && curr.val > low) {
                q.add(curr.right);
            }
        }

        return sum;
    }


    static Node insert(Node node, int data){
        if (node == null) {
            return newNode(data);
        }
        
        if (data <= node.val) {
            node.left = insert(node.left, data);
        }

        else {
            node.right = insert(node.right, data);
        }
        
        return node;
    }
    
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 3);
        insert(root, 7);
        insert(root, 18);
        int L = 7, R = 15;
        System.out.print(rangeSumBST(root, L, R));
    }
}


/*
 * 
 * Question 1 :
 * Range Sum of BST
 * We have a Binary Search Tree consisting of N nodes and two positive
 * integers L and R, the task is to find the sum of values of all the
 * nodes that lie in the range [L, R]..
 * 
 * Sample Input1:
 * 
 *          8
 *         / \
 *        5   11
 *       / \   \
 *      3   6   20
 * 
 * Sample Output1 : 11
 * 
 * 
 * Time Complexity : o(n)
 * Space Complexity: o(n)
 * 
 * 
 */
