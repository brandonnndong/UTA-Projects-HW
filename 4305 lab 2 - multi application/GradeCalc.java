package Dong_Lab_2;
import java.util.Scanner;

public class GradeCalc {
    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] scores = new double[5];

        // Ask the user to enter five test scores
        System.out.println("Enter five test scores:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Test score " + (i + 1) + ": ");
            scores[i] = scanner.nextDouble();
        }

        // Calculate the average score
        double average = calcAvg(scores[0], scores[1], scores[2], scores[3], scores[4]);

        // Display each score and its corresponding letter grade
        System.out.println("\nScores and Letter Grades:");
        for (int i = 0; i < 5; i++) {
            char grade = gradeConv(scores[i]);
            System.out.printf("Score %.1f| Grade %c%n", scores[i], grade);
        }

        // Display the average score
        System.out.printf("Average: %nScore %.1f| Grade %c%n", average,gradeConv(average));
        // Close the scanner
        scanner.close();
    }

    //Method to find the average test score
    public static double calcAvg(double score1, double score2, double score3, double score4, double score5) {
        return (score1 + score2 + score3 + score4 + score5) / 5;
    }

    // Method to determine the letter grade based on the test score
    public static char gradeConv(double score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    
}

