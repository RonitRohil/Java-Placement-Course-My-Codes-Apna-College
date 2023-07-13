public class KeypadCombinations {

    static char[][] list = {{}, 
                            {}, 
                            {'a','b','c'}, 
                            {'d','e','f'}, 
                            {'g','h','i'}, 
                            {'j','k','l'}, 
                            {'m','n','o'}, 
                            {'p','q','r','s'}, 
                            {'t','u','v'},
                            {'w','x','y','z'}};
    

    public static void letterCombination(String num)
    {
        int len = num.length();

        if(len == 0)
        {
            System.out.println("");
            return;
        }

        combi(0, len, new StringBuilder(), num);

    }

    public static void combi(int pos, int len, StringBuilder sb, String num)
    {
        if(pos == len)
        {
            System.out.print(sb.toString() + " ");
        }

        else
        {
            char[] letters = list[Character.getNumericValue(num.charAt(pos))];

            for(int i = 0; i < letters.length; i++)
            {
                combi(pos + 1, len, new StringBuilder(sb).append(letters[i]), num);
            }
        }
    }

    public static void main(String[] args) {
        letterCombination("23");
        letterCombination("2");
        letterCombination("");

    }
}


/*
 * 
 * 
 * Given a string containing digits from 2-9 inclusive, 
 * print all possible letter combinations that 
 * the number could represent. You can print the 
 * answer in any order. A mapping of digits to letters
 * (just like on the telephone buttons) is given below. 
 * Note that 1 does not map to any letters.
 * 
 * Sample Input 1 : digits = "23"
 * Sample Output 1 : "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
 * 
 * Sample Input 2 : digits = "2"
 * Sample Output 2 : "a", "b", "c"
 * 
 * Sample Input 3 : digits = ""
 * Sample Output 3 : ””
 * 
 * 
 */