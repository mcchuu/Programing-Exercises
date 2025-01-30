import java.util.Scanner;  // import scanner from java until package to accept user input

// class to countdown from user input
public class factorial {
    static void main() {  
        Scanner scanner = new Scanner(System.in);  // accept input from the user    
        int num = 0;

        boolean valid = false; // error flag to check for valid input
    
        // while loop until valid input
        while (!valid) {
          // input is valid if able to cast to interger
          try {
            System.out.print("Enter a number: "); // output to system to prompt user for number
            num = scanner.nextInt();
            valid = true;
    
          // else raise an exception to clear invalid input
          } catch (Exception e) {
    
            System.out.println("Invalid input."); // output to the system invalid input message
            scanner.nextLine();
          }
    
        }
        
        int i;  // initalize a counter
        int fact = 1;  // initalize factorial variable

        // reassign the product of counter and factorial and increment counter until counter is one more than number
        for(i = 1; i < num + 1; i++){
          fact=fact*i;
        }
        
        System.out.println("factorial of " + num + " is " + fact);

            scanner.close();  // close scanner to avoid data leak
    }

    public static void main(String[] args) {
        main();  // call main function
    }
}