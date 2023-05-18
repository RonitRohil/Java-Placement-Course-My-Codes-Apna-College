import java.io.BufferedOutputStream;

public class Buyandsellstock {

    public static int buynsellstock(int prices[])
    {
        int n = prices.length;
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < n; i++)
        {
            if (buyPrice < prices[i]) 
            {
                // profit
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);                
            }

            else
            {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) 
    {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(buynsellstock(prices));
    }
}
