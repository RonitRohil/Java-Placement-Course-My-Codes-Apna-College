public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }


    // Inserting Values in BST
    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        }

        else {
            // right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }


    // Inorder Traversal 
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 

    // Search in BST
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        }

        else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 1)) {
            System.out.println("KEY FOUND");
        }
        
        else {
            System.out.println("KEY NOT FOUND");
        }
    }
}



/*
 * 
 * BST
 *  - Left Subtree Nodes < Root
 *  - Right Subtree Nodes > Root
 *  - Left and Right Subtrees are also BST with no duplicates
 * 
 *  ==> Node: In this most problems will be solved using recusrsion i.e.
 *  by dividing into subproblems and making recursive calls on subtrees.
 * 
 * Search a BST
 * 
 */