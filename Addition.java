import java.util.Random;
import java.util.Scanner;


public class Addition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        // Generate two random numbers between 0 and 9
        int number1 = r.nextInt(10);
        int number2 = r.nextInt(10);

        // Prompt user for input
        // PRINT "What is " + number1 + " + " + number2 + "? "
        // READ answer
        System.out.print("What is " + number1 + " + " + number2 + "? ");
        int answer = scanner.nextInt();

        // Keep asking until the user gets it right
        while (answer != number1 + number2) { 
            System.out.print("Wrong answer. Try again. What is " + number1 + " + " + number2 + "? ");
            answer = scanner.nextInt();
        }

        // Correct answer message
        System.out.print("You got it!");

        scanner.close();
    }
}