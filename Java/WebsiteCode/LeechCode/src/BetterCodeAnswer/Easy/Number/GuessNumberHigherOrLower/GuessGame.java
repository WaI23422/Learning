package BetterCodeAnswer.Easy.Number.GuessNumberHigherOrLower;

public class GuessGame {
    private static int number = 2;


    public static int getNumber() {
        return number;
    }

    public static void setNumber(int n) {
        number = n;
    }
    
    public int guess(int n) {
        if (n < number) {
            return 1;
        } else if (n > number) {
            return -1;
        } else {
            return 0;
        }
    }
}
