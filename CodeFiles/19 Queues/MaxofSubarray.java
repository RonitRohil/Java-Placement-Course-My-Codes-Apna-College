import java.util.Deque;
import java.util.LinkedList;

public class MaxofSubarray {
    
    static void printMax(int arr[], int n, int k)
    {
        Deque<Integer> q = new LinkedList<>();
        int i;

        for(i = 0; i < k; ++i)
        {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }

        for(; i < n; i++)
        {
            System.out.print(arr[q.peek()] + " ");
            while ((!q.isEmpty()) && q.peek() <= i - k) {
                q.removeFirst();
            }

            while((!q.isEmpty()) && arr[i] >= arr[q.peekLast()])
            {
                q.removeLast();
            }
            q.addLast(i);
        }

        System.out.print(arr[q.peek()]);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        printMax(arr, arr.length, k);
    }
}


/*
 * 
 * 
 * Question 5 :
 * Maximum of all subarrays of size k
 * We have an array arr[] of size N and an integer K. Find the maximum 
 * for each and every contiguous subarray of size K.
 * 
 * Sample Input 1 : N = 9, K = 3 arr = 1 2 3 1 4 5 2 3 6
 * Sample Output 1 : 3 3 4 5 5 5 6
 * 
 * 
 */