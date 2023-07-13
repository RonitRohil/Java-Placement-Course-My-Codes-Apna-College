// prerequisite = sorted array
// Time Complexity = O(log n)

public class Binary_Search {

    public static int binary_search(int num[], int key)
    {
        int low = 0;
        int high = num.length - 1;
        
        while (low <= high) {
            int mid = (low + high)/2;

            if(num[mid] == key)
            {
                return mid;
            }

            if(num[mid] > key)
            {
                high = mid - 1;
            }

            else
            {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) 
    {
        int num[] = {2,4,6,8,10,12,14,16};
        int key = 5;

        int n = binary_search(num, key);

        System.out.println(n);
    }
}
