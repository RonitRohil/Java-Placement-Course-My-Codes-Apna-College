

public class Palindrome {

    public static boolean isPalindrome(String str)
    {
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) == str.charAt(str.length() - i - 1))
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "racecar";
        System.out.print(isPalindrome(str));
    }
}
