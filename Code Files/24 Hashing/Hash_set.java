import java.util.*;

public class Hash_set {
    
    public static void main(String[] args) {
        // HashSet<Integer> set = new HashSet<>();

        // set.add(1);
        // set.add(2);
        // set.add(4);
        // set.add(2);
        // set.add(1);

        // System.out.println(set);

        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Jaipur");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        Iterator it = cities.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();

        for (String city : cities) {
            System.out.println(city);
        }

    }
}


/*
 * 
 * 
 * HashSet
 *  - No duplicates
 *  - Unordered
 *  - NULL is allowed
 * 
 * Math - sets =>> collection of unique elements
 * 
 * HashSet Operations
 *  HashSet<Integer> hs = new HashSet<>();
 * 
 * add(key) - O(1)
 * contains(key) - O(1)
 * remove(key) - O(1)
 * 
 * Iterations on HAshSET
 * a. Using Iterators
 *      - set.iterator()
 *  
 * b. Using ENhanced for loop
 * 
 * 
 */