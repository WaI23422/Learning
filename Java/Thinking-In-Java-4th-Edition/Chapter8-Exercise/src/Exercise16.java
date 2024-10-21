import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 16: ) Create a class that produces a sequence of chars. Adapt this class so that it can be an input to a Scanner object.
 *      </body>
 * </html>
 */
public class Exercise16 implements Readable{
    private static Random rand = new Random(47);
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private int count;
    Exercise16(int count) { this.count = count; }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0)
            return -1;

        for (int i = 0; i < 10; i++) {
            cb.append(alphabet[ rand.nextInt(alphabet.length) ]);
        }
        cb.append(" ");
        
        return 10;
    }

    public static void main(String[] args) {
        System.out.println("Exercise 16 Result: ");

        Scanner s = new Scanner( new Exercise16(5) );
        while (s.hasNext()){
            System.out.println(s.next());
        }

        System.out.println("----------------------------------------------------");
    }
}