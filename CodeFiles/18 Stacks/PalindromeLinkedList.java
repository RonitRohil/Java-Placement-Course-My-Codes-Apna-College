import java.util.*;;

public class PalindromeLinkedList {
    
    public static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindrome(Node head)
    {
        Node slow = head;
        boolean ispalindrome = true;
        Stack<Integer> stack = new Stack<>();

        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (head != null) {
            int i = stack.pop();
            if(head.data == i)
            {
                ispalindrome = true;
            }

            else
            {
                ispalindrome = false;
                break;
            }

            head = head.next;
        }

        return ispalindrome;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        
        boolean condition = isPalindrome(one);
        System.out.println("Palindrome : " + condition);
    }
}

/*
 * 
 * Question 1 :
 * Palindrome Linked List
 * We have a singly linked list of characters, write a function that 
 * returns true if the given list is a palindrome, else false.
 * 
 * Input : A->B->C->B->A
 * Output : Yes It is Palindrome
 * 
 */
