public class CheckPalindrone {
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

    public static void main(String[] args) {
        CheckPalindrone ll = new CheckPalindrone();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);

        ll.PrintList();
        System.out.println(ll.checkPalindrone());
    }
}
