package Dong_Lab_2;

public class Temp {
    // Main method to run the program
    public static void main(String[] args) {
        tempTable();
    }
    
    // Method to convert Fahrenheit to Celsius
    public static double celsius(double fah) {
        return 5.0 / 9.0 * (fah - 32);
    }

    // Method to display the temperature conversion table
    public static void tempTable() {
        System.out.printf("%-12s | %s%n", "Fahrenheit", "Celsius");
        System.out.println("-------------------------");
        for (int f = 0; f <= 20; f++) { // Loop from 0 to 20
            double c = cel(f);
            System.out.printf("%-12d | %.2f%n", f, c);
        }
    }
}
