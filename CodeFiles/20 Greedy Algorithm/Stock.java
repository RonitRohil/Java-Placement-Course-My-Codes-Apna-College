public class Stock {

    static int maxProfit(int prices[], int n)
    {
        int buy = prices[0], max_profit = 0;

        for (int i = 1; i < n; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            }

            else if (prices[i] - buy > max_profit) {
                max_profit = prices[i] - buy;
            }
        }

        return max_profit;
    }


    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 6, 4 };
        int n = prices.length;
        int max_profit = maxProfit(prices, n);
        System.out.println(max_profit);
    }
}


/*
 * 
 * Question 4 :
 * Best Time to Buy and Sell Stock
 * Given an array prices[] of length N, representing the prices of the
 * stocks on different days, the task is to find the maximum profit 
 * possible for buying and selling the stocks on different days
 * using transactions where at most one transaction is allowed.
 * Note: Stock must be bought before being sold. 
 * 
 * 
 * Sample Input 1 : prices[] = {7, 6, 4, 3, 1}
 * Sample Output 1 : 0
 * 
 * Sample Input 2 : prices[] = {7, 1, 5, 3, 6, 4]
 * Sample Output 2 : 5
 * 
 * 
 */