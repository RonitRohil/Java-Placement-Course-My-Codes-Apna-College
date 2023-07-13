class Node{
    int data;
    Node left, right;
    
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class InvertBinaryTree {
    
    Node root;

    void mirror() {
        root = mirror(root);
    }

    Node mirror(Node node) {
        if (node == null) {
            return node;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    void inOrder() {
        inOrder(root);
    }

    void inOrder(Node node) {
        if (node == null)
        {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        System.out.println("");
        tree.mirror();
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();

    }
}


/*
 * 
 * 
 * Question 2 :
 * Invert Binary Tree
 * Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree 
 * M(T) with left and right children of all non-leaf nodes interchanged.
 * 
 * Input: 
 * 
 *          1           |          1
 *         / \          |         / \
 *        2   3         |        3   2
 *       / \ / \        |       / \ / \
 *      4  5 6  7       |      7  6 5  4
 * 
 * Output: Yes
 * 
 * Time Complexity : o(n)
 * Space Complexity: o(n)
 * 
 * 
 */