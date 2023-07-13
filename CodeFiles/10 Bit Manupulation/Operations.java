public class Operations {

    //Get ith Bit
    public static int getIthBit(int n, int i)
    {
        int bitMask = 1 << i;

        if ((n & bitMask) == 0) {
            return 0;
        }

        else
        {
            return 1;
        }
    }

    //Set ith Bit
    public static int setIthBit(int n, int i)
    {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    // Clear ith Bit
    public static int ClearIthBit(int n, int i)
    {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }
    
    //Update Ith Bit
    public static int UpdateIthbit(int n, int i, int newBit)
    {
        // if (newBit == 0) {
        //     return ClearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }


        n =  ClearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    // Clear i Bits
    public static int cleaIBits(int n, int i)
    {
        int bitMask = (~0)<<i;
        return n & bitMask;
    }

    //Clear range of Bits
    public static int ClearRangebits(int n, int i, int j)
    {
        int a = ((~0) << (j + 1));
        int b = (1<<i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static void main(String[] args) {

        System.out.println(getIthBit(10, 2));
        System.out.println(getIthBit(10, 3));

        System.out.println(setIthBit(10, 2));

        System.out.println(ClearIthBit(10, 1));

        System.out.println(UpdateIthbit(10, 2, 3));

        System.out.println(cleaIBits(15, 2));

        System.out.println(ClearRangebits(10, 2, 4));
    }
}
