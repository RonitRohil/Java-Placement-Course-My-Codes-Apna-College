public class Subsets {

    public static void find_subsets(String str, String ans, int i)
    {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            }
            else
            {
                System.out.println(ans);
            }
            return;
        }

        //recusion

        //Yes Choice
        find_subsets(str, ans + str.charAt(i), i+1);

        //No Choice
        find_subsets(str, ans, i+1);
    }
    
    public static void main(String[] args) {
        String str = "abc";
        find_subsets(str, "", 0);
    }
}

/*
 * 
 * Time - o(2^n * n)
 * 
 * Space O(n)
 * 
 */