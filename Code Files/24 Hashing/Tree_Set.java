import java.util.*;

public class Tree_Set {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Jaipur");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        for (String city : cities) {
            System.out.println(city);
        }

        System.out.println();

        LinkedHashSet<String> city = new LinkedHashSet<>();
        city.add("Delhi");
        city.add("Jaipur");
        city.add("Mumbai");
        city.add("Noida");
        city.add("Bengaluru");

        for (String cit : city) {
            System.out.println(cit);
        }

        System.out.println();

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Jaipur");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Bengaluru");
        
        for (String ct : ts) {
            System.out.println(ct);
        }

        System.out.println();

    }
}


/*
 * 
 * Treeset
 * 
 * sorted in asc order
 * NULL values are NOT Allowed
 * 
 */