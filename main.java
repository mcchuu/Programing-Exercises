public class Main
{
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 5;
        int num3 = 15;
        int num4 = 7;
        
        if (num1 % 3 == 0)
            {System.out.println("Fizz");
        }
        else if (num2 % 5 == 0)
            {System.out.println("Buzz");
        }
        else if (num3 % 15 == 0)
            {System.out.println("FizzBuzz");
        }
        else
            {System.out.println("Hello World");
        }
    }
}
