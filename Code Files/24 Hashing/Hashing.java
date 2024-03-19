import java.util.HashMap;
import java.util.Set;

public class Hashing {
    
    public static void main(String[] args) {
        //Create
        HashMap<String, Integer> hm = new HashMap<>();

        // insert
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 75);
        hm.put("Indonesia", 50);
        hm.put("Nepal", 6);
        hm.put("Europe", 4);

        System.out.println(hm);

        // // Get

        // int populataion = hm.get("India");
        // System.out.println(populataion);

        // // Contains Key
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("Inia"));

        // // Remove
        // System.out.println(hm.remove("Inidia"));
        // System.out.println(hm.remove("China"));

        // System.out.println(hm);

        // // size
        // System.out.println(hm.size());

        // // isempty
        // System.out.println(hm.isEmpty());

        // Iteration
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key = " + k + " , value = " + hm.get(k));
        }
    }
}


/*
 * 
 * 
 * Hashing 
 *  - maps
 *      -> HashMap
 *      -> Linked Hashmap
 *      -> TreeMap
 * 
 *  - sets
 *      -> HashSet
 *      -> Linked Hashset
 *      -> TreeSet
 * 
 * 
 * Very Optimized code
 * 
 * 
 * => HashMap
 *      (key, value) - pair
 *  HashMap<String, Integer> hm = new HashMap<>();
 * 
 * COnst TIme Operations
 *  - put (key, val)
 *  - get (key)
 *  - containsKey(key)
 *  - remove(key)
 * 
 * 
 *      * Unordered Map
 * 
 * 
 * 
 */