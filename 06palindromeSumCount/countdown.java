import java.util.Scanner;  // import scanner from java until package to accept user input

// class to countdown from user input
public class countdown {
    static void count() {  
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
        
        // print each number and decrement i till greater than 0
        for (int i = num; i >= 0; i--) {
            System.out.println(i);  // output num to system
        }
            scanner.close();  // close scanner to avoid data leak
    }

    public static void main(String[] args) {
        count();  // call main function
    }
}

