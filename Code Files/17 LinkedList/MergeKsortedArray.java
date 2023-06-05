public class MergeKsortedArray {
    
    public static class Node {
        int data; 
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void push(int new_data){
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    public static void printList(Node node)
    {
        while (node != null) 
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /*
     * 
     * Time: O(n*logk)
     * Space: O(n)
     * 
     */

    public static Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        if (a == null) {
            return b;
        }

        else if(b == null)
        {
            return a;
        }

        if(a.data <= b.data)
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        }

        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    public static Node mergeKlist(Node arr[], int last)
    {
        while (last != 0) {
            int i = 0;
            int j = last;

            while (i < j) {
                arr[i] = sortedMerge(arr[i], arr[j]);
                i++;
                j--;

                if(i >= j)
                {
                    last = j;
                }
            }
        }

        return arr[0];
    }

    public static void main(String[] args) {
        int k = 3;
        // int n = 4;

        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        Node head = mergeKlist(arr, k - 1);

        printList(head);

    }
}


/*
 * 
 * 
 * Question 5 :
 * Merge k Sorted Lists
 * We have K sorted linked lists of size N each, merge them and 
 * print the sorted output.
 * 
 * Sample Input 1 : k = 2, n = 2
 *      l1 = 1->3->NULL
 *      l2 = 6->8->NULL
 *      l3 = 9->10->NULL
 * 
 * Sample Output 1 : 1>3->6->8->9->10->NULL
 * 
 * 
 */