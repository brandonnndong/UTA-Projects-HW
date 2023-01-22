package extreme_bonus;

import java.util.Scanner;
    
public class Hello {
    
    public static void main(String[] args) {
        String userName = System.getProperty("user.name");
        System.out.println("Hello " + userName +"! ");
        System.out.println("Is this your name(yes or no)?\n");

        Scanner scanner = new Scanner( System.in );
        
            String gotName = scanner.next();
            if (gotName.equals("yes")){
				
                System.out.println("\nHello " + userName + "! ");
            } 
            else if (gotName.equals("no")){
					
                System.out.print("\nPlease enter your name: ");
            
                String givenName = scanner.next();
                System.out.println("Hello " + givenName + "! ");
            }
            

        scanner.close();
        
    }
}
