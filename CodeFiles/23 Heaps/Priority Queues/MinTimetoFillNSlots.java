import java.util.*;

public class MinTimetoFillNSlots {

    public static void minTime(int arr[], int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[N + 1];
        int time = 0;

        for (int i = 0; i < K; i++) {
            q.add(arr[i]);
            vis[arr[i]] = true;
        }

        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                int curr = q.poll();

                if (curr - 1 >= 1 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.add(curr - 1);
                }

                if (curr + 1 <= N && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.add(curr + 1);
                }
            }

            time++;
        }

        System.out.println(time - 1);
    }

    public static void main(String[] args) {
        int N = 6;
        int arr[] = { 2, 6 };
        int K = arr.length;
        minTime(arr, N, K);
    }
}


/*
 * 
 * 
 * Question 2 :
 * Minimum time required to fill given N slots
 * 
 * We have an integer N which denotes the number of slots, and an array
 * arr[] consisting of K integers in the range [1, N] repreand. Each 
 * element of the array are in the range [1, N] which represents the 
 * indices of the filled slots. At each unit of time, the index with 
 * filled slot fills the adjacent empty slots. The task is to find the 
 * minimum time taken to fill all the N slots.
 * 
 * 
 * Sample Input 1 : N = 5, K = 5, arr[] = {1, 2, 3, 4, 5}
 * Sample Output 1 : 1
 * 
 * Sample Input 1 : N = 6, K = 2, arr[] = {2, 6}
 * Sample Output 1 : 2
 * 
 * Time Complexity  : o(n)
 * Space Complexity: o(n)
 * 
 * 
 */