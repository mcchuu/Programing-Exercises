import java.util.Random;
import java.util.Scanner;

public class ArrayWeGo {
    
    public static void task1(){
        // Declare an Array
        
        int[] numbers;
        numbers = new int[5];

        System.out.println(
            "element 0 is: " + numbers[0] + 
            "\nelement 1 is: " + numbers[1] + 
            "\nelement 2 is: " + numbers[2] + 
            "\nelement 3 is: " + numbers[3] + 
            "\nelement 4 is: " + numbers[4]);
    }

    public static void task2(){
        //  Declare an Array and fill the values in multiple lines
        
        int[] numbers = new int[5];
        numbers[0] = 21;
        numbers[1] = 12;
        numbers[2] = 22;
        numbers[3] = 11;
        numbers[4] = 2;

        System.out.println(
            "\ncomplete array is:\n{"
            + numbers[0] + ", " 
            + numbers[1] + ", "
            + numbers[2] + ", "
            + numbers[3] + ", "
            + numbers[4] + "}");

    }

    public static void task3(){
        // Declare an Array and fill the values in one line
        int[] numbers = {21, 12, 22, 11, 2};
        System.out.println(
            "\ncomplete array is:\n{"
            + numbers[0] + ", " 
            + numbers[1] + ", "
            + numbers[2] + ", "
            + numbers[3] + ", "
            + numbers[4] + "}");
    }

    public static void task4(){
        // Declare an Array and fill the values using a for loop
        int[] numbers = new int[5];
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i + 1) * 3;
        }

        System.out.println(
            "\ncomplete array is:\n{"
            + numbers[0] + ", " 
            + numbers[1] + ", "
            + numbers[2] + ", "
            + numbers[3] + ", "
            + numbers[4] + "}");
    }
    

    public static void task5(){
        // Declare an Array and fill the values using a for loop, char edition
        
        char[] charArray = new char[5];
        charArray[0] = 'A';
        
        int x = 65;
        for (int i = 1; i < 5; i++) {
            x += 2;
            char n = (char)x;
            charArray[i] = n;
        }

        System.out.println(
            "\ncomplete array is:\n{"
            + charArray[0] + ", " 
            + charArray[1] + ", "
            + charArray[2] + ", "
            + charArray[3] + ", "
            + charArray[4] + "}");


    }

    public static void task6(){
        // User-Defined Array with Random Values
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("\nEnter size of array: ");
            int len = scanner.nextInt();
            int[] numbers = new int[len];

            System.out.print("\ncomplete array is:\n{ ");
            for (int i = 0; i < len; i++) {
                numbers[i] = random.nextInt(101);
                System.out.print( numbers[i] + " ");
            }
            System.out.print("}");

    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
    }
}