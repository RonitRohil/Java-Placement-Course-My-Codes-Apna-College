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

    //Slow - Fast Apporach
    public Node findMid(Node head)
    {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }

        return slow; // slow id my midNode
    }

    //Check Palindrome
    public boolean checkPalindrone()
    {
        if(head == null || head.next != null)
        {
            return true;
        }

        //find mid - step 1
        Node midNode = findMid(head);

        //Reverse 2nd Half - Step 2
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        // Check left half and right half

        while(right != null)
        {
            if(left.data != right.data)
            {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;

    }

    // Detect a loop in LL
    public static boolean isCycle()
    {
        // Floyd's cycle finding algorithm
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                return true;
            }   
        }

        return false;
    }
    
    public static void removeCycle()
    {
        //detect cycle

        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                cycle = true;
                break;
            }   
        }


        if (cycle == false) {
            return;
        }


        // find meeting point
        slow = head;
        Node prev = null;

        while(slow != fast)
        {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }


        //remove cycle -> last.next = null;
        prev.next = null;

    }
    
    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        // // ll.PrintList();
        // ll.addFirst(2);
        // // ll.PrintList();
        // ll.addFirst(1);
        // // ll.PrintList();
        // // System.out.println(size);
        // ll.addLast(3);
        // // ll.PrintList();
        // ll.addLast(4);
        // // ll.PrintList();
        // ll.add(2, 9);
        // ll.PrintList();
        // // System.out.println(size);

        // // ll.removeFirst();
        // // ll.PrintList();
        // // System.out.println(size);

        // // ll.removeLast();
        // // ll.PrintList();
        // // System.out.println(size);

        // // System.out.println(ll.iterativeSearch(4));
        // // System.out.println(ll.RecursiveSearch(2));
        // // ll.reverse();
        // // ll.PrintList();

        // ll.deleteNthFromEnd(1);
        // ll.PrintList();

        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);

        // ll.PrintList();
        // System.out.println(ll.checkPalindrone());

        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1->2->3->1

        System.out.println(isCycle());
        
        removeCycle();
        System.out.println(isCycle());

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
 * find mid node
 * check palindrome
 * Detect a loop in ll
 * 
 * 
 * REmove loop in ll
 *  exaplanation
 * 
 * slow distance = x + a*d + y
 * fast distance = x + b*d + y
 * 
 * x + b*d  + y = 2 * (x + a*d + y)
 * bd - 2ad = x + y
 * 
 * x = d(b - 2a) - y
 * 
 * x = kd - y
 * 
 * 
 * 
 */
