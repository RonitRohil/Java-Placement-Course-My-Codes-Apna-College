public class Decimal_to_Binary {

    public static void dectobin(int n)
    {
        int pow = 0;
        int biNum = 0;

        while(n > 0)
        {
            int last_digit = n % 2;
            biNum = biNum  + (last_digit* (int)Math.pow(10, pow));
            pow++; 

            n = n/2;
        }

        System.out.print(biNum);
    }

    public static void main(String[] args) {

        dectobin(7);
        
    }
}
