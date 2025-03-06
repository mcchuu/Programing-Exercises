import java.util.Random;
import java.util.Scanner;
// megaball 1-25
public class MegaMillions {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static double balance;
    static double totalWinnings = 0;
    static double totalSpent = 0;

    public static void main(String[] args) {
        initializeGame();

        // TODO: Run the game loop until the player can no longer play
        runGame();
        printGameSummary();
    }

    // TODO: Initialize the game (set balance, print welcome message)
    public static void initializeGame() {
        balance = 50.0;
        System.out.println("       WELCOME TO MEGA MILLIONS!\n =====================================");
        System.out.println("You start with $50.00.\n\n--------------------------------------");
        System.out.printf("Current Balance: $%.2f", balance);
        System.out.println("\n--------------------------------------");
    }

    // TODO: Run the game loop (handle multiple rounds of play)
    String choice;
    public static void runGame() {
        String choice;
        while (balance>=2){
            System.out.println("Do you want Quick Pick? (yes/no): ");
            choice = scanner.nextLine().toLowerCase();

            if (choice.equalsIgnoreCase("yes")) {
                playRound();
                break;
            }
            else if(choice.equalsIgnoreCase("no")) {
                break;
            }
            else {
                System.out.println("Invalid input. Try again");
            }
        }
    }

    // TODO: Play one round (handle number selection, ticket purchase, drawing numbers, checking results, updating balance)
    public static void playRound() {
        int[] numbers = generateNumbers();
        int megaball = numbers[5];

        System.out.print("Your Quick Pick: \n[" );
        for (int i = 0; i < 5; i++) {
            System.out.print( numbers[i] + " ");
        }
        System.out.print("] Mega Ball: "+ megaball);
    }

    // TODO: Update balance after ticket purchase and winnings
    public static void updateBalance() {
    }

    // TODO: Print game summary (total spent, total winnings, final balance)
    public static void printGameSummary() {
        System.out.println("\n====================================\n             GAME OVER\n====================================");
        System.out.printf("Total Spent: $%.2f\nTotal Winnings: $%.2f\nFinal Balance: $%.2f\n====================================",totalSpent, totalWinnings, balance);
    }

    // TODO: Generate an array of 5 unique random numbers (1-70)
    public static int[] generateNumbers() { 
        int[] numbers = new int[6];
        numbers[5] =random.nextInt(26);
        int count = 0;

        while (count < 5){
            int num = random.nextInt(71);
            if (!contains(numbers, num, count)){
                numbers[count] = num;
                count++;
            }
        }
        return numbers;
    }

    // TODO: Get a valid number input from the user within a given range
    public static void getValidNumber() {
    }

    // TODO: Check if an array contains a specific number
    public static boolean contains(int[] numbers, int num, int count) {
        boolean unique = false;
        for (int i = 0; i < count; i++) {
            if (numbers[i] == num) {
                unique = true;
            }
        }
        return unique;
    }

    // TODO: Count matching numbers between user and winning numbers
    public static void countMatches() {

    }

    // TODO: Determine the prize amount based on matches
    public static void getPrize() {
    }

    // TODO: Get a random Megaplier value (2x, 3x, 4x, or 5x)
    public static int getRandomMegaplier() {
        int[] megapliers = {2, 3, 4, 5};
        return megapliers[random.nextInt(megapliers.length)];
    }
}
