import java.util.*;

public class PairSum_2 {

    public static boolean pairSum2(ArrayList<Integer> list, int target)
    {
        int bp = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                // breaking point
                bp = i;
                break;
            }
        }

        int lp = bp + 1; // smallest
        int rp = bp; // largest
        int n = list.size();

        while(lp != rp)
        {
            // case1
            if(list.get(lp) + list.get(rp) == target)
            {
                return true;
            }

            //case 2
            if(list.get(lp) + list.get(rp) < target)
            {
                lp = (lp + 1)%n;
            }

            else
            {
                rp = (n + rp - 1) %n;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        // 11, 15, 6, 8, 9, 10 - Sorted & Rotated
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);
        int target = 16;

        System.out.println(pairSum2(height, target));


    }
}


/*
 * find if any pair in a sorted and rotated arraylist has
 * a target sum
 * 
 */
