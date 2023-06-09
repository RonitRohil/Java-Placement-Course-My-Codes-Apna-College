import java.util.*;

public class Deque_jcf {
    
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
    }
}


/*
 * 
 * Deque = DOuble ended queue
 * Dequeue = not same
 * 
 * 
 */