package Dong_Lab_2;
import java.util.Scanner;

public class PresentVal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fValue; // Desired future value
        double interestRate;
        int years; // Number of years

        // Loop to allow user to experiment with different interest rates
        while (true) {
            System.out.print("Future Value: ");
            fValue = scanner.nextDouble();
            System.out.print("Annual interest rate (in decimal form): ");
            interestRate = scanner.nextDouble();
            System.out.print("Number of years: ");
            years = scanner.nextInt();
            // Break the loop if a negative interest rate is entered
            if (interestRate < 0) {
                System.out.println("Exiting the program.");
                break;
            }

            // Calculate present value
            double pValue = pValue(fValue, interestRate, years);
            System.out.printf("You need to deposit: $%.2f%n",pValue);
        }

        scanner.close();
    }
    
    // Method to calculate the present value
    public static double pValue(double fValue, double interestRate, int years) {
        return fValue / Math.pow(1 + interestRate, years);
    }
}

