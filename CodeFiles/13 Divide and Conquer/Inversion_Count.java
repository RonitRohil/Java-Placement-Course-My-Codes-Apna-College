public class Inversion_Count {
    
    //brute force approach
    public static int getInverseCount(int arr[]){
        int n = arr.length;
        int invCount = 0;

        for(int i = 0; i < n - 1; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(arr[i] > arr[j])
                {
                    invCount++;
                }
            }
        }

        return invCount;
    }

    // Modified Merge Sort

    public static int merge(int arr[], int left, int mid, int right)
    {
        int i = left;
        int j = mid;
        int k = 0;

        int invCount = 0;

        int temp[] = new int[(right -left + 1)];

        while((i < mid) && (j <= right))
        {
            if(arr[i] <= arr[j])
            {
                temp[k] = arr[i];
                k++;
                i++;
            }

            else
            {
                temp[k] = arr[j];
                invCount += (mid - i);
                k++;
                j++;
            }
        }

        while (i < mid) 
        {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= right) 
        {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for(i = left, k = 0; i <= right; i++, k++)
        {
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static int mergeSort(int arr[], int left, int right) {
        int invCount = 0;

        if(right > left)
        {
            int mid = (right + left)/2;

            invCount = mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid + 1, right);
            invCount += merge(arr, left, mid + 1, right);
        }

        return invCount;
    }

    public static int getInversion(int arr[])
    {
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 20, 6, 4, 5};
        int arr1[] = {2, 4, 1, 3, 5};
        int arr2[] = {2, 3, 4, 5, 6};
        int arr3[] = {5, 5, 5};

        System.out.println(getInverseCount(arr));
        System.out.println(getInverseCount(arr1));
        System.out.println(getInverseCount(arr2));
        System.out.println(getInverseCount(arr3));


        System.out.println(getInversion(arr));
        System.out.println(getInversion(arr1));
        System.out.println(getInversion(arr2));
        System.out.println(getInversion(arr3));
    }
}


/*
 * 
 * Given an array of integers. Find the Inversion Count in 
 * the array. Inversion Count: For an array, inversion 
 * count indicates how far (or close) the array is from
 * being sorted. If the array is already sorted then the 
 * inversion count is 0. If an array is sorted in the reverse 
 * order then the inversion count is the maximum. Formally, 
 * two elements a[i] and a[j] form an inversion 
 * if a[i] > a[j] and i < j.
 * 
 * Sample Input 1 : N = 5, arr[ ] = {2, 4, 1, 3, 5}
 * Sample Output 1 : 3, 
 * because it has 3 inversions - (2, 1), (4, 1), (4, 3). 
 * 
 * 
 * Sample Input 2 : N = 5, arr[ ] = {2, 3, 4, 5, 6}
 * Sample Output 2 : 0, because the array is already sorted
 * 
 * 
 * Sample Input 3 : N = 3, arr[] = {5, 5, 5}
 * Sample Output 3 : 0, because all the elements of the 
 * array are the same & already in a sorted manner.
 * 
 * (Hint : A sorting algorithm will be used to 
 * solve this question.)
 * 
 * Note - This question is important. Even if you are not able
 * to come up with the approach, please understand the solution.
 * 
 */