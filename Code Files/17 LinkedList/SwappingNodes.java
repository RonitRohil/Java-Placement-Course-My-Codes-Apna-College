public class SwappingNodes {
    
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

    public void swapNodes(int x, int y)
    {
        if(x == y)
        {
            return;
        }

        Node prevX = null;
        Node currX = head;

        while(currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null;
        Node currY = head;

        while(currY != null && currY.data != y)
        {
            prevY = currY;
            currY= currY.next;
        }

        if(currX == null || currY == null)
        {
            return;
        }

        if(prevX != null)
        {
            prevX.next = currY;
        }

        else
        {
            head = currY;
        }

        if(prevY != null)
        {
            prevY.next = currX;
        }

        else
        {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

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

    public static void main(String[] args) {
        SwappingNodes list = new SwappingNodes();
        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        list.PrintList();
        list.swapNodes(4, 3);
        list.PrintList();
    }
}


/*
 * 
 * 
 * Question 3 :
 * Swapping Nodes in a Linked List
 * We have a linked list and two keys in it, swap nodes for two
 * given keys. Nodes should be swapped by changing links. Swapping
 * data of nodes may be expensive in many situations when data 
 * contains many fields. It may be assumed that all keys in the 
 * linked list are distinct.
 * 
 * Sample Input 1 : 1->2->3->4, x = 2, y = 4
 * Sample Output 1 : 1->4->3->2
 * 
 * 
 */