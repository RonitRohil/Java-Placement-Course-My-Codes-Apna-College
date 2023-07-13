import java.util.*;

public class Linked_hashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 75);

        System.out.println(lhm);


        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 75);

        System.out.println(hm);
    }
}


/*
 * 
 * Linked HashMap
 * -> keys are inserted in order
 * LinkedHashMap< > hm = new LinkedHashMap<>();
 * 
 */