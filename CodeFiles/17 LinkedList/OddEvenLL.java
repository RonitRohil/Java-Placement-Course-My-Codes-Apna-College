public class OddEvenLL {

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


    public void segregateEvenOdd()
    {
        Node end = head;
        Node prev = null;
        Node curr = head;

        while (end.next != null)
        {
            end = end.next;
        }
        
        Node new_end = end;

        while (curr.data %2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        if(curr.data % 2 == 0)
        {
            head = curr;
            while (curr != end) {
                if(curr.data % 2 == 0)
                {
                    prev = curr;
                    curr = curr.next;
                }

                else
                {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        }

        else
        {
            prev = curr;
        }

        if(new_end != end && end.data % 2 != 0)
        {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

    public static void main(String[] args) {
        OddEvenLL llist = new OddEvenLL();
        llist.push(1);
        llist.push(10);
        llist.push(81);
        llist.push(6);
        llist.push(4);
        llist.push(23);
        llist.push(0);

        llist.PrintList();
        llist.segregateEvenOdd();

        llist.PrintList();
    }
}


/*
 *
 * 
 * Question 4 :
 * Odd Even Linked List
 * We have a Linked List of integers, write a function to modify the
 * linked list such that all even numbers appear before all the odd
 * numbers in the modified linked list. Also, keep the order of
 * even and odd numbers same.
 * 
 * Sample Input 1 : 8->12->10->5->4->1->6->NULL
 * Sample Output 1 : 8->12->10->4->6->5->1->NULL
 * 
 * Sample Input 2 : 1->3->5->7->NULL
 * Sample Output 2 : 1->3->5->7->NULL
 * 
 * 
 */