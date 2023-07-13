import java.util.ArrayList;
import java.util.Arrays;

public class MinOptoHalveArraySum {

    static int minops(ArrayList<Integer> nums) {
        int sum = 0;
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            maxElement = Math.max(maxElement, nums.get(i));
        }

        int target = (sum + 1) / 2;
        int count = 0;

        while (maxElement > target) {
            maxElement = (maxElement + 1) / 2;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 5, 8, 19));

        int count = minops(nums);
        System.out.println(count);
    }
}



/*
 * 
 * 
 * Minimum Operations to Halve Array Sum
 * We have an array Arr[], the task is to find out the minimum number of 
 * operations to make the sum of array elements lesser or equal to half 
 * of its initial value. In one such operation, it is allowed to half 
 * the value of any array element.
 * 
 * Sample Input 1 : [1, 5, 8, 19]
 * Sample Output 1 : 3
 * 
 * Time Complexity  : o(nlogn)
 * Space Complexity: o(n)
 * 
 * 
 */