public class HW_Find_Element {

    //function to search 
    public static int search(int num[], int target)
    {
        int n = num.length;
        // index of minimun element
        int min_idx = min_element(num);

        if (num[min_idx] <= target && target <= num[n - 1]) 
        {
            return binary_search(num, target, min_idx, n - 1);
        }

        else
        {
            return binary_search(num, target, 0, min_idx);
        }
    }

    // function to find the index
    public static int binary_search(int num[], int target, int left, int right)
    {
        int n = num.length;
        int r = right;
        int l = left;

        while(l < r)
        {
            int mid = (l + r)/2;

            if (num[mid] == target) 
            {
                return mid;
            }

            if(num[mid] > target)
            {
                r = mid - 1;
            }

            else
            {
                l = mid + 1;
            }
        }

        return -1;
    }

    // function to find the index of the min element of the array
    public static int min_element(int num[])
    {
        int n = num.length;
        int left = 0;
        int right = n - 1;

        while(left < right)
        {
            int mid = (left + right)/2;

            if(mid > 0 && num[mid - 1] > num[mid])
            {
                return mid;
            }

            else if(num[left] <= num[mid] && num[mid] > num[right])
            {
                left = mid + 1;
            }

            else
            {
                right = mid - 1;
            }
        }

        return left;
    }


    public static void main(String[] args)
    {
        int num[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 8;

        System.out.println(search(num, target));
    }
}
