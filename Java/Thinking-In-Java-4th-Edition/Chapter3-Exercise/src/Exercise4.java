// Write a program that uses two nested for loops and the modulus
// operator (%) to detect and print prime numbers (integral numbers that are not evenly
// divisible by any other numbers except for themselves and 1). 

class myMath{
    public static void PrimeFromRange(int startRange, int endRange){
        for (int i = startRange; i <= endRange; i++) {

            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("Exercise 4 Result: ");
        
        myMath.PrimeFromRange(0, 100);

        System.out.println("----------------------------------------------------");
    }
}
