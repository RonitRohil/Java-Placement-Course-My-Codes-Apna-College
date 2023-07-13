import java.util.*;

public class Linked_Hashset {

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

        LinkedHashSet<String> city = new LinkedHashSet<>();
        city.add("Delhi");
        city.add("Jaipur");
        city.add("Mumbai");
        city.add("Noida");
        city.add("Bengaluru");

        for (String cit : city) {
            System.out.println(cit);
        }
    }
}

/*
 * 
 * it maintains order
 *  
 */