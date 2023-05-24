public class FindAllOccurance {

    public static void allOcc(int arr[], int key, int i)
    {
        if(i == arr.length)
        {
            return;
        }

        if(arr[i] == key)
        {
            System.out.println(i);
        }

        allOcc(arr, key, i+ 1);
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        allOcc(arr, key, 0);
    }
}


/*
 * 
 * For a given integer array of size N. You have to find 
 * all the occurrences (indices) of a given element (Key) 
 * and print them. Use a recursive function to solve this
 * problem.
 * 
 * Sample Input : arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2}, 
 *                  key = 2
 * 
 * Sample Output : 1 5 7 8
 * 
 */