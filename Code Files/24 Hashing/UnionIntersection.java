import java.util.*;

public class UnionIntersection {
    
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        HashSet<Integer> set = new HashSet<>();

        //union
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union: " + set.size());

        // Intersection
        set.clear();
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println("Intersection: " + count);
    }
}

/*
 * 
 * Union and Intersection of 2 Arrays
 * 
 * arr1 = {7, 3, 9}
 * arr2 = {6, 3, 9, 2, 9, 4}
 * 
 * Union = 6 {7, 3, 9, 6, 2, 4}
 * Intersection = 2 {3, 9}
 * 
 */
