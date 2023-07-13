public class IF_Else10 {
    public static void main(String[] args) {
        int age = 16;
 
        if(age >= 18)
        {
            System.out.println("adult : drive, vote");
        }
        
        if(age > 13 && age < 18)
        {
            System.out.println("Teenager");
        }

        else
        {
            System.out.println("Not Adult");
        }
    }    
}
