import java.util.Scanner;


public class DoIt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declare a variable for user input

        int number;

        do {
            System.out.print("Enter a positive number: ");
            number = scanner.nextInt();

            if ( number < 0 ) {
                System.out.println("Invalid input. Try again");
            }
        }
        while (number < 0 );
        System.out.print("You entered: " + number);

        scanner.close();
    }
}