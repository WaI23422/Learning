// Write a program that simulates coin-flipping.

import java.util.Random;

public class Exercise7 {
    static void CoinFlipping(int value){
        switch (value) {
            case 1:
                System.out.println("Heads");
                break;
            case 0:
                System.out.println("Tails");
                break;
            default:
                System.out.println("Value Out Of Range");
                break;
        }
    }
    public static void main(String[] args) {
        System.out.println("Exercise 7 Result: ");
        Random randObj = new Random();
        int randNumber = randObj.nextInt(2);

        System.out.print("Coin Flip Result: ");
        CoinFlipping(randNumber);
        System.out.println("----------------------------------------------------");
    }
}
