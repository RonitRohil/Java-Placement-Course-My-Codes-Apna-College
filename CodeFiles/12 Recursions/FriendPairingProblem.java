public class FriendPairingProblem {

    public static int PairingFriends(int n)
    {
        if(n == 1 || n == 2)
        {
            return n;
        }

        return PairingFriends(n - 1) + (n- 1)*PairingFriends(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(PairingFriends(n));
    }
}

/*
 * 
 * Given n friends each one can remain single or can be 
 * paired up with some other friend. Each friend can be
 * paired only once. Find out the total number of ways in 
 * which friends can remain single or can be paired up.
 * 
 */