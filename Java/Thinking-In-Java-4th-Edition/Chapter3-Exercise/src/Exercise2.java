// Write a program that generates 25 random int values. For each value,
// use an if-else statement to classify it as greater than, less than, or equal to a second
// randomly generated value. 

import java.util.Random;

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("Exercise 2 Result: ");

        Random myRand = new Random();
        int[] randNumber = new int[25];

        for (int i = 0; i < randNumber.length; i++) {
            randNumber[i] = myRand.nextInt(0,10);
        }

        int secondRandNumb = randNumber[1];

        for (int i : randNumber) {
            if (i>secondRandNumb) {
                System.out.println("Number "+ i +" Greater than "+ secondRandNumb);
            } else if (i < secondRandNumb) {
                System.out.println("Number "+ i +" Less than "+ secondRandNumb);
            } else {
                System.out.println("Number "+ i + " Equal to "+ secondRandNumb);
            }
        }

        System.out.println("----------------------------------------------------");
    }
}
