public class FastExponention {

    public static int FastExpo(int a, int n)
    {
        int ans = 1;

        while(n > 0)
        {
            if((n & 1) != 0)
            {
                ans = ans * a;
            }

            a = a * a;
            n = n >> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(FastExpo(3, 4));
        System.out.println(FastExpo(4, 4));
    }
}

// modular exponentiation **
// http://graphics.stanford.edu/~seander/bithacks.html