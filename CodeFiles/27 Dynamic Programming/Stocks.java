public class Stocks {

    public static int max_profit(int arr[], int b[], int n, int tranFee) {
        int i, j, profit;
        int left, right, diff_day = 1;
        int sum = 0;

        b[0] = 0;
        b[1] = diff_day;

        for (i = 1; i < n; i++) {
            left = 0;
            right = diff_day;
            sum = 0;

            for (j = n-1; j >= i; j--) {
                profit = (arr[right] - arr[left]) - tranFee;
                if (profit > 0) {
                    sum = sum + profit;
                }

                left++;
                right++;
            }

            if (b[0] < sum) {
                b[0] = sum;
                b[1] = diff_day;
            }

            diff_day++;
        }

        return 0;
    }
    
    public static void main(String[] args) {
        int arr[] = { 6, 1, 7, 2, 8, 4 };
        int n = arr.length;

        int[] b = new int[2];
        int tranFee = 2;

        max_profit(arr, b, n, tranFee);
        System.out.println(b[0]+", "+b[1]);
    }
}


/*
 * 
 * 
 * Question 3 :
 * Maximum profit after buying and selling stocks with transaction fees
 * We have an array of positive integers containing the price of stocks 
 * and transaction fee, the task is to find the maximum profit and the 
 * difference of days on which you are getting the maximum profit.
 * 
 * Input: arr[] = {6, 1, 7, 2, 8, 4} transactionFee = 2
 * Output: 8 1
 * 
 * Input: arr[] = {7, 1, 5, 3, 6, 4} transactionFee = 1
 * Output: 5 1
 * 
 * Time Complexity : o(n2)
 * Space Complexity: o(1)
 * 
 * 
 */