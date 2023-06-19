import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class NodeComparator implements Comparator<Node> {
    
    public int compare(Node k1, Node k2)
    {
        if (k1.data > k2.data)
        {
            return 1;
        }
        
        else if (k1.data < k2.data)
        {
            return -1;
        }
        return 0;
    }
}

public class MergeKSortedLL {
    
    

    public static void printList(Node node){
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    static Node mergeKList(Node[] arr, int K) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());

        Node head = new Node(0);
        Node last = head;

        for (int i = 0; i < K; i++) {
            if (arr[i] != null) {
                queue.add(arr[i]);
            }
        }

        if (queue.isEmpty()) {
            return null;
        }

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            last.next = curr;
            last = last.next;

            if (curr.next != null) {
                queue.add(curr.next);
            }
        }

        return head.next;
    }
    
    public static void main(String[] args) {
        int N = 3;
        Node[] a = new Node[N];
        
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);

        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        
        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
        head3.next.next = new Node(10);
        head3.next.next.next = new Node(11);
        Node res = mergeKList(a, N);
        
        if (res != null)
        {
            printList(res);
        }
        
        System.out.println();

    }
}


/*
 * 
 * 
 * Question 5 :
 * Merge K Sorted Linked List
 * 
 * We have K linked lists each of size N and each list is sorted in
 * non-decreasing order, merge them into a single sorted (non-decreasing
 * order) linked list and print the sorted linked list as output.
 * 
 * Sample Input 1 :
 * 
 *      K = 3, N = 3
 *      list1 = 1->3->7->NULL
 *      list2 = 2->4->8->NULL
 *      list3 = 9->10->11->NULL
 * 
 * Sample Output 1 : 1->2->3->4->7->8->9->10->11
 * 
 * Time Complexity  : o(n*k*logk)
 * Space Complexity: o(k)
 * 
 * 
 */