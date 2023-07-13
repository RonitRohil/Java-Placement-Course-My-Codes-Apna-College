

public class Strings {

    //printing letters
    public static void printletters(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static void main(String[] args) {
        // char arr[] = {'a', 'b', 'c', 'd'};
        // String str = "abcd";
        // String str2 = new String("xyz");

        // Scanner sc = new Scanner(System.in);
        // String name;
        // name = sc.nextLine();

        // System.out.println(name);

        //lenght function
        String fullName = "Ronit Jain";
        System.out.println(fullName.length());

        //concatation
        String firstName = "Ronit";
        String LastName = "Jain";

        String full_name = firstName + " " + LastName;
        System.out.println(full_name);
        System.out.println(full_name.charAt(0));
        printletters(fullName);
    }
    
}
