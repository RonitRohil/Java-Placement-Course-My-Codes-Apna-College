public class FirstOccuranceinArray {

    public static int FirstOcc(int arr[], int key, int i){

        if (i == arr.length - 1) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return FirstOcc(arr, key, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        System.out.println(FirstOcc(arr, 5, 0));
    }
}
