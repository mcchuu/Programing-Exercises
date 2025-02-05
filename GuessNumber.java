import java.util.Scanner;


public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 6;

        // Prompt the user to start guessing
        System.out.print("Guess a magic number between 0 and 10");

        // Repeat until the correct guess is made
        while (true) {
            System.out.print("\n\nEnter your guess: ");
            int guess = scanner.nextInt();

            if ( guess == number) {
                System.out.print("Yes, the number is " + number);
                break;
            }
            else if ( guess > number ) {
                System.out.print("Your guess is too high");
            }
            else {
                System.out.print("Your guess is too low");
            }
        }

        scanner.close();
    }
}