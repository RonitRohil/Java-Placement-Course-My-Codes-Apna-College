import java.io.BufferedOutputStream;
import javax.sound.midi.VoiceStatus;

public class Sort {

    // Bubble Sort
    public static void bubbleSort(int arr[])
    {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    //swaap
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int arr[])
    {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }

            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void Insertion_Sort(int arr[])
    {
        for(int i = 1; i < arr.length; i++)
        {
            int curr =  arr[i];
            int prev = i - 1;

            // Finding out the correct pos to insert
            while(prev >= 0 && arr[prev] > curr) 
            {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // insertion
            arr[prev + 1] = curr;
        }
    }

    //Count Sort - O(N + logN)
    public static void CountSort(int arr[])
    {
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            largest  = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest+1];

        for(int i = 0; i < arr.length; i++)
        {
            count[arr[i]]++;
        }

        // sorting
        int j = 0;
        for(int i = 0; i < count.length; i++)
        {
            while(count[i] > 0)
            {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArr(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int arr [] = {5, 4, 1, 3, 2};
        
        // bubbleSort(arr);
        // selectionSort(arr);
        // Insertion_Sort(arr);
        CountSort(arr);
        printArr(arr);
    }
    
}
