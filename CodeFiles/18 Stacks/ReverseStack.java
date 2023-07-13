import java.util.*;

public class ReverseStack {

    public static void PushatBottom(Stack<Integer> s ,int data)
    {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        PushatBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s)
    {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        PushatBottom(s, top);
    }

    public static void printStack(Stack<Integer> s)
    {
        while(!s.isEmpty())
        {
            System.out.println(s.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // printStack(s);
        reverseStack(s);
        printStack(s);
    }
}
