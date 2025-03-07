import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MegaMillions {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static double balance;
    static double totalWinnings = 0;
    static double totalSpent = 0;
    static double spent = 0; // money spent in current game

    public static void main(String[] args) {
        initializeGame();
        runGame();
        printGameSummary();
    }

    // Initialize the game (set balance, print welcome message)
    public static void initializeGame() {
        balance = 50.0;
        System.out.println("\n       WELCOME TO MEGA MILLIONS!\n =====================================\nYou start with $50.00.");
    }

    // Run the game loop (handle multiple rounds of play)
    public static void runGame() {
        while (balance >= 2) {
            playRound();
            
            if (balance < 2) { 
                break;
            }
            System.out.print("\nDo you want to play again? (yes/no): ");
            while (true) { 
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    break; // continues loop to play again
                } else if (choice.equalsIgnoreCase("no")) {
                    return; // ends game 
                } else {
                    System.out.println("Invalid input.");
                }
            }
        }
    }

    // Play one round (handle number selection, ticket purchase, drawing numbers, checking results, updating balance)
    public static void playRound() {
        System.out.printf("\n-------------------------------------- \nCurrent Balance: $%.2f\n--------------------------------------\n", balance);
        System.out.print("Do you want Quick Pick? (yes/no): ");
        String choice;
        int[] numbers;
        int megaBall;
        boolean megaplierFlag = false;
        int megaplier = 1;
        int[] winningNumbers = generateNumbers();
        int winningMegaBall = winningNumbers[5];

        while (true) {
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes"))  {
                numbers = generateNumbers();
                megaBall = random.nextInt(25) + 1;
                Arrays.sort(numbers);
                System.out.println("Your Quick Pick: " + Arrays.toString(Arrays.copyOfRange(numbers, 0, 5)) + " Mega Ball: "+ megaBall);
                break;
            } else if (choice.equalsIgnoreCase("no")) {
                numbers = generateNumbers();
                System.out.println("Enter 5 unique numbers (1-70): ");
                    int count = 0;
                    while (count < 5) {
                        int num = getValidNumber(scanner); // pass user input to getValidNumber to validate numbers
                        if (!contains(numbers, num, count)) {
                            numbers[count] = num;
                            count++;
                        } else {
                            System.out.println("Number already entered. Try again.");
                        }
                    }
                    Arrays.sort(numbers);
                    System.out.print("Enter Mega Ball number (1-25): ");
                    while (true) { 
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input.");
                            scanner.next();
                        }
                        megaBall = scanner.nextInt();
                        if (megaBall >= 1 && megaBall <= 25) {
                            break;
                        } else {
                            System.out.println("Invalid input.");
                        }
                    }
                    scanner.nextLine();
                    System.out.println("Your Pick: " + Arrays.toString(Arrays.copyOfRange(numbers, 0, 5)) + " Mega Ball: " + megaBall);
                    break;
            } else {
                System.out.println("Invalid input.");
            }
        }
            System.out.print("Do you want to add Megaplier for $1? (yes/no): ");
            while (true) {
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    totalSpent += 3;
                    megaplierFlag = true;
                    break;
                } else if (choice.equalsIgnoreCase("no")) {
                    totalSpent += 2;
                    break;
                } else {
                    System.out.println("Invalid input.");
                }
            }

            System.out.println("\n====================================\n          WINNING NUMBERS:\n====================================");
            Arrays.sort(winningNumbers);
            System.out.println(Arrays.toString(Arrays.copyOfRange(winningNumbers, 0, 5)) + " Mega Ball: " + winningMegaBall);
        
            // count user matched numbers amount and if Mega Ball matched
            int matchCount = countMatches(numbers, winningNumbers);
            boolean megaBallMatch = (megaBall == winningMegaBall);
            int prize = getPrize(matchCount, megaBallMatch);
            
            if (megaplierFlag) { 
                megaplier = getRandomMegaplier();
            }
            
            System.out.println("Megaplier  Drawn: x" + megaplier + "\n====================================\n");
            
            if (prize > 0 && prize != 100000000) {
                prize *= megaplier;
            }
            
            updateBalance(prize);
            totalWinnings += prize;
            System.out.println("You won: $" + prize);
            System.out.printf("New Balance: $%.2f\n", balance);
    }

    // Update balance after ticket purchase and winnings
    public static void updateBalance(int prize) {
        balance += prize;
        balance -= totalSpent;
        spent += totalSpent;
        totalSpent = 0;  // reset total spent for next round
    }

    // Print game summary (total spent, total winnings, final balance)
    public static void printGameSummary() {
        System.out.println("\n====================================\n             GAME OVER\n====================================");
        System.out.printf("Total Spent: $%.2f\nTotal Winnings: $%.2f\nFinal Balance: $%.2f\n====================================",spent, totalWinnings, balance);
    }

    // Generate an array of 5 unique random numbers (1-70)
    public static int[] generateNumbers() { 
        int[] numbers = new int[6];
                
        int count = 0;
        while (count < 5){
            int num = random.nextInt(70) + 1;
            if (!contains(numbers, num, count)){
                numbers[count] = num;
                count++;
            }
        }
        numbers[5] = random.nextInt(25) + 1;
        return numbers;
    }

    // Get a valid number input from the user within a given range
    public static int getValidNumber(Scanner scanner) {
        int number;
        while (true) {
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            number = scanner.nextInt();
            if (number >= 1 && number <= 70) {
                return number;
            } else {
                System.out.println("Invalid input. Try again");
            }
        }
    }

    // Check if an array contains a specific number
    public static boolean contains(int[] numbers, int num, int count) { 
        boolean unique = false;
        for (int i = 0; i < count; i++) {
            if (numbers[i] == num) {
                unique = true;
            }
        }
        return unique;
    }

    // Count matching numbers between user and winning numbers
    public static int countMatches(int[] numbers, int[] winningNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int x = 0; x < winningNumbers.length; x++) {
                if (numbers[i] == winningNumbers[x]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // Determine the prize amount based on matches
    public static int getPrize(int matchCount, boolean megaBallMatch) {
        if (matchCount == 5 && megaBallMatch) {
            return 100000000;
        } else if (matchCount == 5) {
            return 1000000;
        } else if (matchCount == 4 && megaBallMatch) {
            return 10000;
        } else if (matchCount == 4) {
            return 500;
        } else if (matchCount == 3 && megaBallMatch) {
            return 200;
        } else if (matchCount == 3) {
            return 10;
        } else if (matchCount == 2 && megaBallMatch) {
            return 10;
        } else if (matchCount == 1 && megaBallMatch) {
            return 4;
        } else if (matchCount == 0 && megaBallMatch) {
            return 2;
        } else {
            return 0;
        }
    }

    // Get a random Megaplier value (2x, 3x, 4x, or 5x)
    public static int getRandomMegaplier() {
        return random.nextInt(4) + 2;
    }
}
