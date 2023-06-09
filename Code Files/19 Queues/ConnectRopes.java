import java.util.*;

public class ConnectRopes {
    
    static int minCost(int len[], int size)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            pq.add(len[i]);
        }

        int result = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            result += first + second;
            pq.add(first + second);
        }

        return result;
    }

    public static void main(String[] args) {
        int len[] = {4, 3, 2, 6};
        int size = len.length;
        System.out.println(minCost(len, size));
    }
}


/*
 * 
 * 
 * Question 2 :
 * Connect n ropes with minimum cost
 * 
 * Given are N ropes of different lengths, the task is to connect these 
 * ropes into one rope with minimum cost, such that the cost to connect 
 * two ropes is equal to the sum of their lengths.
 * 
 * Sample Input 1 : N = 4, arr = [4 3 2 6]
 * Sample Output 1 : 29
 * 
 * Sample Input 2 : N = 2, arr = [1 2 3]
 * Sample Output 2 : 9
 * 
 * 
 */