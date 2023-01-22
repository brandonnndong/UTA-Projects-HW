import java.util.Scanner;
    
public class Hello {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );        
        
        System.out.println("What is your name? ");
        
        String givenName = scanner.nextLine();
        System.out.println("Hello " + givenName + "! ");
        
        scanner.close();
    }
}

