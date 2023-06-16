import java.util.ArrayList;

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


    // Delete Node
    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        }

        else if (root.data > val) {
            root.left = delete(root.left, val);
        }

        else {
            // case 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 - single child
            if (root.left == null) {
                return root.right;
            }

            else if(root.right == null) {
                return root.left;
            }

            // case 3 - both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }


    // Function to find inorder successor
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }


    // print in range
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }

        else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        }

        else {
            printInRange(root.right, k1, k2);
        }
    }


    //print path
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }

        System.out.println("Null");
    }


    // Printing root two leaf
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }


    // BST IS valid or not
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;   
        }

        else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }


    // Mirror of BST
    public static Node createMirror(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }


    // Preorder
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    public static void main(String[] args) {
        // int values[] = {1, 1, 1};
        // Node root = null;

        // for (int i = 0; i < values.length; i++) { 
        //     root = insert(root, values[i]);
        // }

        // inorder(root);
        // System.out.println();

        // if (search(root, 1)) {
        //     System.out.println("KEY FOUND");
        // }
        
        // else {
        //     System.out.println("KEY NOT FOUND");
        // }

        // root = delete(root, 1);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // printInRange(root, 3, 5);
        // System.out.println();

        // printRoot2Leaf(root, new ArrayList<>());

        // if (isValidBST(root, null, null)) {
        //     System.out.println("valid");
        // }

        // else {
        //     System.out.println("Not Valid");
        // }


        /*
         *      8
         *     / \
         *   10   5  
         *   /   / \
         * 11   6   3
         * Mirror BST
         * 
         */


        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        preorder(root);

        System.out.println();
        root = createMirror(root);
        preorder(root);


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
 *      by dividing into subproblems and making recursive calls on 
 *      subtrees.
 * 
 * 
 * Search a BST
 * 
 * 
 * Delete a Node 
 *  3 Cases
 *      - No Child (Leaf Node)
 *          => Delete Node
 *          => Return Null to parent
 * 
 *      - One Child
 *          => Delete Node
 *          => Replace with Child Node
 * 
 *      - Two Children
 *          => Replace value with inorder Successor
 *          => Delete the node for inorder Successor
 * 
 *          *Inorder successor always has 0 or 1 child.
 * 
 * 
 * Print in Range n1 and n2
 * 
 * 
 * Print root 2 leaf
 * 
 * 
 * Validate BST - snapdeal, amazon, facebook
 * Approach - 1
 * compare with left and right node
 * Fails some cases
 * 
 * we have to use
 * Approach - 2
 *  - Chech if max value in left subtree < node
 *  - and min value in right subtree > node
 * 
 * 
 * shortcut
 * 
 * Inorder Traversal - Sorted
 *  
 * isValid
 * 
 * Mirror a BST
 * 
 *          8               |       8
 *         / \              |      / \
 *        5   10            |    10   5  
 *       / \    \           |    /   / \
 *      3  6     11         |   11  6   3
 * 
 * 
 * 
 * Converting SOrted array to a Balanced BST
 * arr = [3, 5, 6, 8, 10 ,11, 12]
 * 
 * 
 */