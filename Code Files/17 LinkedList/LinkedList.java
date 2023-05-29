public class LinkedList {

    public static class Node {
        int data; 
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        size++;

        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        size++;

        if(head == null)
        {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void add(int index, int data)
    {

        if(index == 0)
        {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while(i < index - 1)
        {
            temp = temp.next;
            i++;
        }

        // i = idx - 1; temp -> temp.next
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void PrintList()
    {
        if(head ==null)
        {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public int removeFirst()
    {
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast()
    {
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = tail.data;

        Node prev = head;
        for(int i = 0; i < size - 2; i++)
        {
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        size--;

        return val;
    }

    public int iterativeSearch(int key)
    {
        Node temp = head;
        int i = 0;

        while(temp != null)
        {
            if(temp.data == key)
            {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int helper(Node head, int key)
    {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);

        if(idx == -1)
        {
            return -1;
        }

        return idx + 1;
    }

    public int RecursiveSearch(int key)
    {
        return helper(head, key);
    }

    public void reverse()
    {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void deleteNthFromEnd(int n)
    {
        int sz = 0;
        Node temp = head;

        while(temp != null)
        {
            temp = temp.next;
            sz++;
        }

        if(n == sz)
        {
            head = head.next;
            return;
        }

        //sz-n
        int i = 1;
        int itoFind = sz-n;
        Node prev = head;
        while(i < itoFind)
        {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return; 
    }

    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.PrintList();
        ll.addFirst(2);
        // ll.PrintList();
        ll.addFirst(1);
        // ll.PrintList();
        // System.out.println(size);
        ll.addLast(3);
        // ll.PrintList();
        ll.addLast(4);
        // ll.PrintList();
        ll.add(2, 9);
        ll.PrintList();
        // System.out.println(size);

        // ll.removeFirst();
        // ll.PrintList();
        // System.out.println(size);

        // ll.removeLast();
        // ll.PrintList();
        // System.out.println(size);

        // System.out.println(ll.iterativeSearch(4));
        // System.out.println(ll.RecursiveSearch(2));
        // ll.reverse();
        // ll.PrintList();

        ll.deleteNthFromEnd(1);
        ll.PrintList();
    }
}

/*
 * 
 * Linked List
 * addFirst()
 * addLast()
 * add()
 * size
 * removeFirst()
 * removeLast()
 * printLL()
 * IterativeSearch()
 * RecursiveSearch()
 * reverse a linked list
 * Remove Nth Node from end
 * 
 */
