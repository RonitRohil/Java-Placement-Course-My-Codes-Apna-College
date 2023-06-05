import java.util.*;

public class MaxAreaInHistogram {

    public static void max_Area(int arr[])
    {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next Smaller Right
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) 
        {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) 
            {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = arr.length;
            }

            else
            {
                //top
                nsr[i] = s.peek();
            }

            s.push(i);
        }


        // Next Smaller right
        s = new Stack<>();

        for (int i = 0; i < arr.length; i++) 
        {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) 
            {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            }

            else
            {
                //top
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        //Current Area : width = j - i - 1 = nsr[i] - nsl[i] - 1

        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("Max area in Histogram = " + maxArea); 

    }

    public static void main(String[] args) {
        int height[] = {2, 1, 7, 6, 5, 3};
        max_Area(height);
    }
}


/*
 * 
 * Given an array of integers heights representing the histogram's bar 
 * height where the width of each bar is 1, return the area of the 
 * largest rectangle in the histogram
 * 
 * heights = [2, 1, 5, 6, 2, 3]
 * ans  = 10
 * 
 * width 
 * - Next smaller left - i
 * - Next smaller right - j
 *  = width => j - i - 1
 * 
 */