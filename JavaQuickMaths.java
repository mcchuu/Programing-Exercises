import java.util.Scanner;

public class JavaQuickMaths {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // 1. Loop from 1.0 to 5.0, incrementing by 0.5 and print the rounding results
        System.out.println("Looping from 1.0 to 5.0 with rounding methods:");
        for (double i = 1.0; i <= 5.0; i+=0.5) {
            System.out.println("Number: " + i + " Ceil: " + Math.ceil(i) + " Floor: " + Math.floor(i) + " Rint: " + Math.rint(i) + " Round: " + Math.round(i));
        }
        
        // 2. Prompt the user to enter a decimal number and print results
        System.out.print("\nEnter a decimal number: ");
        double num = scanner.nextDouble();
        System.out.println("Ceil: " + Math.ceil(num) + " Floor: " + Math.floor(num) + " Rint: " + Math.rint(num) + " Round: " + Math.round(num));
        
        // 3. Prompt the user to enter an integer
        System.out.print("\nEnter an interger: ");
        int integer = scanner.nextInt();
        System.out.print("Enter a word: ");
        String string = scanner.next();
        System.out.println("You entered integer: " + integer + "\nYou entered string: " + string);
        
        // 4. Demonstrate type casting

        //implicit cast
        int x = integer;
        double x1 = x;
        //explicit cast
        double f = num;
        int x2 = (int)f;
        //ASCII representation
        char x3 = (char) integer;

        System.out.println("\nImplicit cast (int > double): " + x1 + "\nExplicit cast (double > int): " + x2 + "\nCasting int to char (ASCII): " + x3);

        // 5. Prompt the user to enter a character and print converted character to its ASCII value (int)
        System.out.print("\n\nEnter a character: ");
        char character = scanner.next().charAt(0);
        int x4 = character;
        System.out.println("ASCII value of '" + character + "' is: " + x4);

        // 6. Demonstrate String vs. new String()
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println("String Comparisons");
        System.out.printf("str1 == str2: %b%n", str1 == str2);
        System.out.printf("str1 == str3: %b%n", str1 == str3);
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        
        scanner.close();  // close scanner to avoid data leak
    }
}