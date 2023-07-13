public class Quick_Sort {

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int arr[], int start_idx, int end_idx) {
        if (start_idx < end_idx) {
            int pidx = partition(arr, start_idx, end_idx);
    
            quickSort(arr, start_idx, pidx - 1); // left 
            quickSort(arr, pidx + 1, end_idx); // right
        }
    }
    

    public static int partition(int arr[], int start_idx, int end_idx) {
        int pivot = arr[end_idx];
        int i = start_idx - 1;
    
        for (int j = start_idx; j <= end_idx - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    
        int temp = arr[end_idx];
        arr[end_idx] = arr[i + 1];
        arr[i + 1] = temp;
    
        return i + 1;
    }
    
    
    
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        quickSort(arr, 0, arr.length - 1);
        PrintArray(arr);
    }
}


/*
 * 
 * pivot - last element
 * partition
 * Quick sort - right part
 * Quick sort - left part
 * 
 */