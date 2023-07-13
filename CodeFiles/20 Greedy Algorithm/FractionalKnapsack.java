import java.util.*;;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[val.length][2];
        // 0th col => idx; 1st col => ratio

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double)weight[i];
        }

        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int finalVal = 0;

        for (int i = ratio.length-1; i >= 0; i--) {
            int idx = (int)ratio[i][0];

            if (W >= weight[idx]) {
                // include full time
                finalVal += val[idx];
                W -= weight[idx];
            }

            else{
                // include fractional item
                finalVal += (ratio[i][1] * W);
                W = 0;
                break;
            }
        }

        System.out.println(finalVal);
    }
}


/*
 * 
 * Fractional Knapsack
 * Given the wieghts and values of N items, put these items in a knapsack
 * of capacity W to get the maximum total values in the knapsack.
 * 
 * value = [60, 100, 120]
 * weight = [10, 20, 30]
 * W = 50
 * 
 * ans = 240
 * 
 * 
 */