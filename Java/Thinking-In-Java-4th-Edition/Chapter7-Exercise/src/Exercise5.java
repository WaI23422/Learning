import Exercise1_5.Bicycle;
import Exercise1_5.Cycle;
import Exercise1_5.Tricycle;
import Exercise1_5.Unicycle;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 5: Starting from Exercise 1, add a wheels( ) method in Cycle, which returns the number of wheels. Modify ride( ) to call wheels( ) and verify that polymorphism works.
 *      </body>
 * </html>
 */
public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("Exercise 5 Result: ");

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
