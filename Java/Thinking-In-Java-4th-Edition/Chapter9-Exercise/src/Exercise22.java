import Exercise22_23.Selector;
import Exercise22_23.Sequence;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 22: Implement reverseSelector( ) in Sequence.java. 
 *      </body>
 * </html>
 */
public class Exercise22 {
    public static void main(String[] args) {
        System.out.println("Exercise 22 Result: ");

        Sequence sequence = new Sequence(10);

        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));

        Selector selector1 = sequence.selector();
        while(!selector1.end()) {
            System.out.print(selector1.current() + " ");
            selector1.next();
        }

        System.out.println();

        Selector selector2 = sequence.rselector();
        while(!selector2.end()) {
            System.out.print(selector2.current() + " ");
            selector2.next();
        }

        System.out.println();
        
        System.out.println("----------------------------------------------------");
    }
}