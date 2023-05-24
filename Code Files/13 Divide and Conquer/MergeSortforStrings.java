public class MergeSortforStrings {

    public static String[] mergeSort(String[] arr, int start_idx, int end_idx)
    {
        if(start_idx == end_idx)
        {
            String[] A = { arr[start_idx]};
            return A;
        }

        int mid = start_idx + (end_idx - start_idx)/2;

        String[] arr1 = mergeSort(arr, start_idx, mid);
        String[] arr2 = mergeSort(arr, mid + 1, end_idx);

        String[] arr3 = merge(arr1, arr2);
        return arr3;
    }

    public static String[] merge(String[] arr1, String[] arr2)
    {
        int m = arr1.length;
        int n = arr2.length;

        String[] arr3 = new String[m + n];

        int idx = 0;

        int i = 0;
        int j = 0;

        while(i < m && j < n)
        {
            if (isAlphabeticallySmaller(arr1[i], arr2[j])) {
                arr3[idx] = arr1[i];
                i++;
                idx++;
            }

            else
            {
                arr3[idx] = arr2[j];
                j++;
                idx++;
            }
        }

        while(i < m){
            arr3[idx] = arr1[i];
            i++;
            idx++;
        }

        while (j < n) {
            arr3[idx] = arr2[j];
            j++;
            idx++;
        }

        return arr3;
    }

    public static boolean isAlphabeticallySmaller(String str1, String str2)
    {
        if(str1.compareTo(str2) < 0)
        {
            return true;
        }

        return false;
    }

    public static void PrintArray(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    

    public static void main(String[] args) {
        String arr[] = { "sun", "earth", "mars", "mercury" };
        String a[] = mergeSort(arr, 0, arr.length - 1);

        PrintArray(arr);
        System.out.println();
        PrintArray(a);
    }
}

/*
 *
 *  Question 1 : Apply Merge sort to sort an array of Strings. 
 * (Assume that all the characters in all the Strings are in 
 * lowercase).
 * 
 * Sample Input 1 : arr = { "sun", "earth", "mars", "mercury" }
 * Sample Output 1 : arr = { "earth", "mars", "mercury", "sun"}
 * 
 * 
 */