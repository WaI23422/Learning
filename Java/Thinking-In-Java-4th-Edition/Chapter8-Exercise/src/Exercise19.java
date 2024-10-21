import java.util.Random;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 19: Create a framework using Factory Methods that performs both coin tossing and dice tossing.
 *      </body>
 * </html>
 */
public class Exercise19 {
    public static void play(TossFactory f) {
        Tossing t = f.getTossType();
        t.toss();
    }
    public static void main(String[] args) {
        System.out.println("Exercise 19 Result: ");

        play(new CoinFactory());
        play(new DiceFactory());

        System.out.println("----------------------------------------------------");
    }
}

interface Tossing { void toss(); }

class Coin implements Tossing {
    private static Random rand = new Random(47);

    public void toss() {
        System.out.print("Coin tossing: ");

        if (rand.nextBoolean())
            System.out.println("Heads!");
        else
            System.out.println("Tails!");
    }
}

class Dice implements Tossing {
    private static Random rand = new Random(47);

    public void toss() {
        System.out.print("Dice tossing: ");
        System.out.println( rand.nextInt(6) + 1);
    }
}

interface TossFactory { Tossing getTossType(); }

class CoinFactory implements TossFactory {
    public Tossing getTossType() { return new Coin(); }
}

class DiceFactory implements TossFactory {
    public Tossing getTossType() { return new Dice(); }
}