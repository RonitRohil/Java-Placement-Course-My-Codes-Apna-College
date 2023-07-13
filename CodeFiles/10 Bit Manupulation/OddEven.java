public class OddEven {

    public static void OddEvenCheck(int n)
    {
        int bitMask = 1;
        if((n & bitMask) == 0)
        {
            System.out.println("Even Number");
        }

        else{
            System.out.println("Odd Number");
        }
    }

    public static void main(String[] args) {
        // odd lSb = 1
        // even lsb = 0
        OddEvenCheck(3);
        OddEvenCheck(14);
        OddEvenCheck(11);

    }
}
