import java.util.*;

public class PairSum {

    //brute force
    public static boolean pairSum1(ArrayList<Integer> list, int target)
    {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }

        return false;
    }

    //2 Pointer Approach
    public static boolean pairSumPointer(ArrayList<Integer> list, int target)
    {
        int lp = 0;
        int rp = list.size() - 1;

        while(lp != rp)
        {
            // case1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // case2
            if(list.get(lp) + list.get(rp) < target)
            {
                lp++;
            }

            else
            {
                rp--;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(2);
        height.add(3);
        height.add(4);
        height.add(5);
        height.add(6);
        int target = 5;

        System.out.println(pairSum1(height, target));
        System.out.println(pairSumPointer(height, target));
    }
}