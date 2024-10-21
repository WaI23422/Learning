import Exercise2_4.Selector;
import Exercise2_4.Sequence;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 4: Add a method to the class Sequence.SequenceSelector that produces the reference to the outer class Sequence.
 *      </body>
 * </html>
 */
public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("Exercise 4 Result: ");

        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++) {sequence.add(Integer.toString(i));}
        
        Selector selector = sequence.selector();

        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        System.out.println("");

        System.out.println("----------------------------------------------------");
    }
}
