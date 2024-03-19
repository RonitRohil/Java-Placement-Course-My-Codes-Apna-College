public class StackUsingLL {
    
    public static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {
        static Node head = null;

        //isEmpty
        public static boolean isEmpty()
        {
            return head == null;
        }

        //push
        public static void push(int data)
        {
            Node newNode = new Node(data);

            if(isEmpty())
            {
                head = newNode;
            }

            newNode.next = head;
            head = newNode;
        }

        //pop
        public static int pop()
        {
            if(isEmpty())
            {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        //peek
        public static int peek()
        {
            if(isEmpty())
            {
                return -1;
            }
            
            return head.data;
        }

    }

    public static void main(String[] args) {
        StackUsingLL.Stack.push(1);
        StackUsingLL.Stack.push(2);
        StackUsingLL.Stack.push(3);

        while(!StackUsingLL.Stack.isEmpty())
        {
            System.out.println(StackUsingLL.Stack.peek());
            StackUsingLL.Stack.pop();
        }
    }
}
