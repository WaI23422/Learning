import Exercise2_4.Selector;
import Exercise2_4.Sequence;
import Exercise2_4.StringStorage;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 2: Create a class that holds a String, and has a toString( ) method that displays this String. Add several instances of your new class to a Sequence object, then display them.
 *      </body>
 * </html>
 */
public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("Exercise 2 Result: ");

        Sequence seq = new Sequence(5);

        for (int i = 0; i < 5; i++){seq.add( new StringStorage(Integer.toString(i)) );}

        Selector selector = seq.selector();

        while(!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }

        System.out.println("----------------------------------------------------");
    }
}

