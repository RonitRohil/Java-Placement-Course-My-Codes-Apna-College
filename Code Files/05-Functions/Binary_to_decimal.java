public class Binary_to_decimal {

    public static void bintoDec(int n)
    {
        int pow = 0;
        int decNum = 0;

        while(n > 0)
        {
            int last_digit = n % 10;
            decNum = decNum  + (last_digit* (int)Math.pow(2, pow));
            pow++; 

            n = n/10;
        }

        System.out.print(decNum);
    }

    public static void main(String[] args) {

        bintoDec(101);
        
    }
}
