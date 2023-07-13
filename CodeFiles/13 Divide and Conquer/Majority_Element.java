public class Majority_Element {

    //Brute Force O(n*2)
    public static int MojorityElement_Brute(int arr[])
    {
        int n = arr.length;

        int majoritycount = n/2;

        for(int i = 0; i < n; i++)
        {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            if (count > majoritycount) {
                return arr[i];
            }
        }

        return -1;
    }

    // Divide and Conquer Approach

    public static int majorityElement_Recursion(int[] nums, int low, int high)
    {
        if(low == high)
        {
            return nums[low];
        }

        int  mid = low + (high - low)/2;
        int left = majorityElement_Recursion(nums, low, mid);
        int right = majorityElement_Recursion(nums, mid + 1, high);

        if(left == right)
        {
            return left;
        }

        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);

        return leftCount > rightCount ? left : right;
    }

    public static int countInRange(int[] nums, int num, int low, int high)
    {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if(nums[i] == num)
            {
                count++;
            }
        }

        return count;
    }   

    public static int MajorityElement(int nums[])
    {
        return majorityElement_Recursion(nums, 0, nums.length - 1);
    }

    
    public static void main(String[] args) {
        int arr[] = {3, 2, 3};
        System.out.println(MojorityElement_Brute(arr));

        int arr1[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(MojorityElement_Brute(arr1));

        System.out.println(MajorityElement(arr));
        System.out.println(MajorityElement(arr1));
    }
}



/*
 * 
 * 
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more 
 * than ⌊n / 2⌋ times. You may assume that the majority element 
 * always exists in the array.
 * 
 * Sample Input 1 : nums = [3,2,3]
 * Sample Output 1 : 3
 * 
 * Sample Input 2 : nums = [2,2,1,1,1,2,2]
 * Sample Output 2 : 2
 * 
 * Constraints (extra Conditions):
 *      ● n == nums.length
 *      ● 1 <= n <= 5 * 104
 *      ● -109 <= nums[i] <= 109
 * 
 * 
 */