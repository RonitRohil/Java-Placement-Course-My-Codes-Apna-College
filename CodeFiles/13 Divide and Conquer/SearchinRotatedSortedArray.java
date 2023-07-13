public class SearchinRotatedSortedArray {

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public static int Search(int arr[], int target, int start_idx, int end_idx)
    {

        if(start_idx > end_idx)
        {
            return -1;
        }

        int mid = start_idx + (end_idx - start_idx)/2;

        //case Found
        if (arr[mid] == target) {
            return mid;
        }

        // mid on L1
        if (arr[start_idx] <= arr[mid]) {
            //case a : left
            if (arr[start_idx] <= target && target <= arr[mid]) {
                return Search(arr, target, start_idx, mid);
            }

            else{
                // case b : right
                return Search(arr, target, mid + 1, end_idx);
            }
        }

        // mid on L2
        else
        {
            // case c : right
            if (arr[mid] <= target && target <= arr[end_idx]) {
                return Search(arr, target, mid+1, end_idx);
            }
            else
            {
                // case d: left
                return Search(arr, target, start_idx, mid - 1);
            }            
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(Search(arr, target, 0, arr.length -1));
        // PrintArray(arr);

    }
}


/*
 * 
 * Search in Rotated Sorted Array
 * 
 * input: sorted, rotated array with distinct numbers (in
 * Asc order) It is rotated at a pivot point. Find the
 * index of given element
 * 
 * Using modifeid binary search
 * 
 */