import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class IndianCoins {
    public static void main(String[] args) {
        Integer[] currency = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        ArrayList<Integer> currencyList = new ArrayList<>(Arrays.asList(currency));
        Collections.sort(currencyList, Collections.reverseOrder());

        int count = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < currencyList.size(); i++) {
            int currentCurrency = currencyList.get(i);
            if (currentCurrency <= amount) {
                while (currentCurrency <= amount) {
                    count++;
                    ans.add(currentCurrency);
                    amount -= currentCurrency;
                }
            }
        }

        System.out.println(count);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
    }
}




/*
 * 
 * We are given an infinite supply of denominations
 *  [1, 2, 5, 10, 20, 50, 100, 500, 2000]
 * FInd min no. of coins to make change for a value V.
 * 
 * It works only on Canonical Coin Systems
 * 
 * V = 121
 * ans = 3(100 + 20 + 1)
 * 
 * V = 590
 * ans = 4 (500 + 50 + 20 +20)
 * 
 * sort in decending order = currencies
 * 
 */
