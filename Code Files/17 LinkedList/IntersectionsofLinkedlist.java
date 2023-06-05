public class IntersectionsofLinkedlist {
    public static class Node {
        int data; 
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    // O(n * m) - solution 1
    public static Node getIntersectionNode(Node head1, Node head2)
    {
        while(head2 != null)
        {
            Node temp = head1;
            while(temp != null)
            {
                if(temp == head2)
                {
                    return head2;
                }

                temp = temp.next;
            }

            head2 = head2.next;
        }

        return null;
    }

    

    public static void main(String[] args) {
       
        Node head1, head2;
        head1 = new Node(10);
        head2 = new Node(3);
        
        Node newNode = new Node(6);
        head2.next = newNode;

        newNode = new Node(9);
        head2.next.next = newNode;

        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode;
        
        newNode = new Node(30);
        head1.next.next = newNode;

        head1.next.next.next = null;

        Node intersectionPoint = IntersectionsofLinkedlist.getIntersectionNode(head1, head2);

        if(intersectionPoint == null)
        {
            System.out.println("No Intersection Point");
        }

        else
        {
            System.out.println("Intersection Point = " + intersectionPoint.data);
        }

    }
}




/*
 * 
 * Intersection of Two Linked Lists
 * In a system there are two singly linked list. By some programming
 * error, the end node of one of the linked lists got linked to the 
 * second list, forming an inverted Y-shaped list. Write a program to
 * get the point where two linked lists merge.
 * 
 *  4               1
 *  \              /
 *   5            2
 *    \          / 
 *     \        3    
 *      \      /
 *       \    /
 *        \  /   
 *         6
 *         |
 *         7
 * We have to find the intersection part in this system.
 *               
 */