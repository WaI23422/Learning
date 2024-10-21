import Exercise1_5.*;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 1: Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. Demonstrate that an instance of each type can be upcast to Cycle via a ride( ) method.
 *      </body>
 * </html>
 */
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("Exercise 1 Result: ");

        Cycle cycle = new Cycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        Unicycle unicycle = new Unicycle();

        cycle.ride(cycle);
        bicycle.ride(bicycle);
        tricycle.ride(tricycle);
        unicycle.ride(unicycle);

        System.out.println("----------------------------------------------------");
    }
}
