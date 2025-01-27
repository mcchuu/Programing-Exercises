import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a character: ");
        char sym = scanner.next().charAt(0);
        
        System.out.print("Enter number of steps: ");
        int step = scanner.nextInt();
        
        for (int i = 1; i <= step; i++) {
            for (int d = 0; d < step - i; d++) {
                System.out.print(' ');
            }
            
            for (int x = 0; x < i; x++) {
                System.out.print(sym);
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}