public class SortedArray {

    public static boolean CheckSortedArray(int arr[], int i)
    {

        if(i == arr.length - 1)
        {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return CheckSortedArray(arr, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 5};
        int arr1[] = {1, 4, 5, 2, 3};

        System.out.println(CheckSortedArray(arr1, 0));
        System.out.println(CheckSortedArray(arr, 0));
    }
}
