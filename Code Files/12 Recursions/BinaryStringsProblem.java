public class BinaryStringsProblem {

    public static void printBinaryString(int n, int lastPlace, String str)
    {

        //base case

        if (n == 0) {
            System.out.println(str);
            return;
        }

        // if (lastPlace == 0) {
        //     printBinaryString(n-1, 0, str.append("0"));
        //     printBinaryString(n-1, 1, str.append("1"));
        // } else {
        //     printBinaryString(n-1, 0, str.append("0"));
        // }

        printBinaryString(n-1, 0, str + ("0"));

        if (lastPlace == 0) {
            printBinaryString(n-1, 1, str + ("1"));
        }
    }

    public static void main(String[] args) {
        printBinaryString(3, 0, "");
    }
}


/*
 * 
 * Print all binary Strings of size N without consecutive 
 * ones.
 * 
 */