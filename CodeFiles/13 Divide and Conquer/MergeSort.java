public class MergeSort {

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void Merge_Sort(int arr[], int start_idx, int end_idx) {
        if (start_idx >= end_idx) {
            return;
        }
        int mid = (start_idx + end_idx) / 2;

        Merge_Sort(arr, start_idx, mid);
        Merge_Sort(arr, mid + 1, end_idx);

        merge(arr, start_idx, mid, end_idx);
    }

    public static void merge(int arr[], int start_idx, int mid, int end_idx) {
        int temp[] = new int[end_idx - start_idx + 1];
        int i = start_idx; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp arr

        while (i <= mid && j <= end_idx) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right part
        while (j <= end_idx) {
            temp[k++] = arr[j++];
        }

        // Copy temp to original arr
        for (k = 0, i = start_idx; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8, -2};
        Merge_Sort(arr, 0, arr.length - 1);
        PrintArray(arr);
    }
}


/*
 * 
 * Time = o(nlogn)
 * Space = O(n)
 * 
 */