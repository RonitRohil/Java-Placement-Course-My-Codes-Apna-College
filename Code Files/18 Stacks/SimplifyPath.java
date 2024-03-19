import java.util.Stack;

public class SimplifyPath {

    public static String simplify(String str)
    {
        Stack<String> st = new Stack<>();
        String res = "";
        res += "/";
        int len_str = str.length();

        for (int i = 0; i < len_str; i++) {
            String dir = "";
            while (i < len_str && str.charAt(i) == '/') 
            {
                i++;
            }

            while (i < len_str && str.charAt(i) != '/') 
            {
                dir += str.charAt(i);
                i++;
            }

            if (dir.equals("..") == true) 
            {
                if (!st.empty()) 
                {
                    st.pop();
                }
            }

            else if(dir.equals(".") == true)
            {
                continue;
            }

            else if(dir.length() != 0)
            {
                st.push(dir);
            }
        }

        Stack<String> s1 = new Stack<>();

        while (!st.empty()) 
        {
            s1.push(st.pop());
        }

        while (!s1.empty()) 
        {
            if (s1.size() != 1) 
            {
                res += (s1.pop() + "/");
            }

            else
            {
                res += s1.pop();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str = new String(": /a/..");
        String res = simplify(str);
        System.out.println(res);
    }
}


/*
 * 
 * Question 2 :
 * Simplify Path
 * We hava an absolute path for a file (Unix-style), simplify it. 
 * Note that absolute path always begin with ‘/’ ( root directory ),
 * a dot in path represent current directory and double dot represents
 * parent directory.
 * 
 * Sample Input 1 : /apnacollege/
 * Sample Output 1 : /apnacollege
 * 
 * 
 * Sample Input 2 : /a/..
 * Sample Output 2 : /
 * 
 * 
 */