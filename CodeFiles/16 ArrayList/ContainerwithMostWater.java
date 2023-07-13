import java.util.ArrayList;

public class ContainerwithMostWater {

    public static int StoreWater(ArrayList<Integer> height)
    {
        int maxWater = 0;

        // brute force 

        // for (int i = 0; i < height.size(); i++) {
        //     for (int j = i + 1; j < height.size(); j++) {
        //         int ht = Math.min(height.get(i), height.get(j));
        //         int width = j - 1;
        //         int currWater = ht* width;
        //         maxWater = Math.max(maxWater, currWater);
        //     }
        // }

        // 2 pointer approach - O(n)

        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {
            // calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            //update pointer
            if(height.get(lp) < height.get(rp))
            {
                lp++;
            }

            else
            {
                rp--;
            }
        }


        return maxWater;
    }


    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(StoreWater(height));
    }
}


/*
 * 
 * Container with most water
 * 
 * For given n lines on x-axis, use 2 lines to form a
 * container such that it holds maximum water
 * 
 * height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
 * 
 * 
 */