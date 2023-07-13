import java.util.*;
import java.util.LinkedList;

public class BinaryTree {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binary_Tree{
        static int idx = -1;


        // build Binary Tree
        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }


        // Preorder Traversal
        public void preorder(Node root) {
            if (root == null) {
                return;
            }
            
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }


        // Inorder Traversal
        public void inorder(Node root) {
            if (root == null) {
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }


        // Post Order Traversal
        public void postorder(Node root) {
            if (root == null) {
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }


        // Level Order Traversal
        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }
                    else {
                        q.add(null);
                    }
                }

                else
                {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }


    // Calculate Height of Binary Tree
    public static int Height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = Height(root.left);
        int rh = Height(root.right);
        return Math.max(lh, rh) + 1;
    }


    // Calculate Count of nodes in binary Tree
    public static int CountNodes(Node root) {
        if (root == null) {
            return 0;  
        }

        int leftCount = CountNodes(root.left);
        int rightCount = CountNodes(root.right);

        return leftCount + rightCount + 1;
    }


    // Calculate sum of nodes in Binary tree
    public static int SumNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = SumNodes(root.left);
        int rightSum = SumNodes(root.right);

        return leftSum + rightSum + root.data;
    }


    // Diameter Function - approach1
    public static int diameter(Node root){ 
        // O(N*2)
        if (root == null) {
            return 0;
        }

        int leftDiam = diameter(root.left);
        int leftHt = Height(root.left);
        int rightDiam = diameter(root.right);
        int rightHt = Height(root.right);

        int SelfDiam = leftHt + rightHt + 1;

        return Math.max(SelfDiam, Math.max(leftDiam, rightDiam));
    }


    // Diameter Function - approach2
    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }


    public static Info Diameter(Node root) {

        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = Diameter(root.left);
        Info righInfo = Diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, righInfo.diam), leftInfo.ht + righInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, righInfo.ht) + 1;

        return new Info(diam, ht);
    }


    // Check if 2 nodes are identical
    public static boolean isIdentical(Node node, Node subroot){
        if (node == null && subroot == null) {
            return true;
        }

        else if(node == null || subroot == null || node.data != subroot.data) {
            return false;
        }

        if (!isIdentical(node.left, subroot.left)) {
            return false;
        }

        if (!isIdentical(node.right, subroot.right)) {
            return false;
        }

        return true;
    }


    // CHecking if subtree exists or not
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    static class Top{
        Node node;
        int hd;

        public Top(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }


    // Top View
    public static void topView(Node root) {
        // Level Order
        Queue<Top> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Top(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Top curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }

                else {
                    q.add(null);
                }
            }

            else {
                if (!map.containsKey(curr.hd)) {
                    // first time my hd is occurring
                    map.put(curr.hd, curr.node);
                }
    
                if (curr.node.left != null) {
                    q.add(new Top(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
    
                if (curr.node.right != null) {
                    q.add(new Top(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }

        System.out.println();

    }


    // K-th level Printing
    public static void KLevel(Node root, int level, int K) {
        if (root == null) {
            return;
        }

        if (level == K) {
            System.out.print(root.data + " ");
            return;
        }

        KLevel(root.left, level+ 1, K);
        KLevel(root.right, level+1, K);
    }


    // Function for getting path
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {

        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }



    // Lowest Common Ancester - Approach 1 - O(n)
    // Space Complexity - O(n)
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last equal node -> i-1th
        Node lca = path1.get(i-1);
        return lca;
    }


    // Lowest Common Ancester - Approach 2 - O(n)
    // Space Complexity - O(n)
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // LeftLCA = val, rightLCA = null

        if (rightLca == null) {
            return leftLca;
        }

        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }


    // Calculating LCA Distance
    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        else if (leftDist == -1) {
            return rightDist + 1;
        }

        else {
            return leftDist + 1;
        }
    }


    // Minimum Distance between two nodes
    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }


    // Kth ancestor
    public static int KAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if (max +1 == k) {
            System.out.println(root.data);
        }

        return max+1;
    }


    // Tranforming to sum tree
    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }


    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String[] args) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // Binary_Tree tree = new Binary_Tree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.postorder(root);
        // System.out.println();
        // tree.levelOrder(root);

        /*
         * 
         *          1
         *         / \
         *        2   3 
         *       / \ / \
         *      4  5 6  7
         * 
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(Height(root));
        // System.out.println(CountNodes(root));
        // System.out.println(SumNodes(root));
        // System.out.println(diameter(root));

        // System.out.println(Diameter(root).diam);
        // System.out.println(Diameter(root).ht);

        /*
         * 
         *        2    
         *       / \
         *      4   5 
         * 
         */

        
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
        
        topView(root);
        topView(subRoot);

        KLevel(root, 1, 3);
        System.out.println();

        System.out.println(lca(root, 4, 5).data);
        System.out.println(lca2(root, 4, 5).data);


        System.out.println(minDist(root, 4, 6));
        System.out.println(KAncestor(root, 2, 5));

        transform(root);
        preOrder(root);
        
    }
}


/*
 * 
 * 
 *          1
 *         / \
 *        2   3 
 *       / \   \
 *      4   5   6
 * 
 * 
 * PreOrder Traversal
 *  - Root
 *  - Left Subtree
 *  - Right Subtree
 *  -> 1 2 4 5 3 6 
 * 
 * 
 * Inorder Traversal
 *  - Left Subtree
 *  - Root
 *  - Right Subtree
 *  -> 1 2 4 5 3 6 
 * 
 * 
 * Postorder Traversal
 *  - Left Subtree
 *  - Right Subtree
 *  - Root
 *  -> 4 5 2 6 3 1 
 * 
 * 
 * Level Order Traversal
 *  -> 1 2 3 4 5 6
 *  - DFS => Depth First Search - LIFO - Stack
 *  - BFS => Breth First Search - FIFO - QUeue
 * 
 *  ->  1 
 *      2 3
 *      4 5 6 
 * 
 * Height of Tree
 *  - nodes and edges
 *  - 3 node = 2 node
 *  - n         n - 1
 * 
 * 
 *          1
 *         / \
 *        2   3 
 *       / \   
 *      4   5  
 *           \
 *            6
 *             \
 *              7 
 * 
 *  Height = 5
 *  Done using Recursion
 * 
 *  Diameter of tree:
 *  
 *  
 *          1
 *         / \
 *        2   3 
 *       / \   \
 *      4   5   6
 * 
 * Diameter = 5
 * 
 * Approach -1
 * recursive approach
 * d = lh + rh + 1;
 * ld, rd
 * 
 * 
 * Subtree
 * 
 * 
 * Top View of Tree
 * 
 *          1
 *         / \
 *        2   3 
 *       / \ / \
 *      4  5 4   6
 *  Output - 4, 2, 1, 3, 6
 * 
 *          1
 *         / \
 *        2   3 
 *         \ 
 *          4
 *           \
 *            5
 *             \
 *              6
 * 
 * Output - 2, 1, 3, 6
 * Done using HASHMAP
 * 
 * Syntax -> Hashmap<String, Integer> map = new HashMap<>();
 * 
 *  
 * 
 * Kth Level of Tree
 * 
 * 
 * Lowest Common Ancester  
 * Approach 1 -> time = o(n) space = o(n)
 * Approach 2 -> time = o(n) space = 
 * 
 * 
 * 
 * Min Distance Between Nodes
 * Requires lowest common ancester concept
 * 
 * 
 * kth Ancestor of Node
 * 
 * 
 * Transforming to a Sum TREE
 * 
 */
