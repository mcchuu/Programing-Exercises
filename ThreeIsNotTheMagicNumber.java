public class ThreeIsNotTheMagicNumber {
    public static void main(String[] args) {
        // Loop through numbers 1 to 20
        int i;
        for ( i = 1 ; i <= 20 ; i++) {
        //     IF number is divisible by 3 THEN skip
            if ( i % 3 == 0 ){
                continue;
            }
            else {
                System.out.println(i);
            }
        }
    }
}