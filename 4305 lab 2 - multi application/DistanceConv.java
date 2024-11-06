package Dong_Lab_2;
import java.util.Scanner;

public class DistanceConv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double meters;

        // Ask the user for the distance in meters
        do {
            System.out.print("Enter a distance in meters: ");
            meters = scanner.nextDouble();
            // Validation check for negative numbers
            if (meters < 0) {
                System.out.println("Please enter a non-negative number.");
            }
        } while (meters < 0);

        // Method for selecting items in menu
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            //Validation check for menu
            while (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please select a valid option.");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1: kilo(meters);
                    break;
                case 2: in(meters);
                    break;
                case 3: ft(meters);
                    break;
                case 4: System.out.println("Quitting the program. Goodbye!");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    // Method to display the menu
    public static void menu() {
        System.out.println("Select an option:");
        System.out.println("1. Convert to kilometers");
        System.out.println("2. Convert to inches");
        System.out.println("3. Convert to feet");
        System.out.println("4. Quit the program");
    }

    // Method to calculate/display the distance in kilometers
    public static void kilo(double meters) {
        double kilometers = meters * 0.001;
        System.out.printf("%.2f meters is %.2f kilometers.%n", meters, kilometers);
    }

    // Method to calculate/display the distance in inches
    public static void in(double meters) {
        double inches = meters * 39.37;
        System.out.printf("%.2f meters is %.2f inches.%n", meters, inches);
    }

    // Method to calculate/display the distance in feet
    public static void ft(double meters) {
        double feet = meters * 3.281;
        System.out.printf("%.2f meters is %.2f feet.%n", meters, feet);
    }

}
