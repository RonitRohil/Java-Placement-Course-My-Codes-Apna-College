

public class BitOperators {
    public static void main(String[] args) {
        //AND &
        System.out.println(5 & 6);

        // OR |
        System.out.println(5 | 6);

        // XOR ^
        System.out.println(5^6);

        // Binary 1's Complement
        System.out.println(~5);
        System.out.println(~0);
        System.out.println(~1);

        // Binary Left Shift << 
        // a << b = a * 2^b
        System.out.println(5 << 2);

        // Binary Right Shift >> 
        // a >> b = a/2^b
        System.out.println(6 >> 1);
    }
}
