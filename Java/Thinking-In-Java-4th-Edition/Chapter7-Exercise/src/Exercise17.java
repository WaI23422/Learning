import Exercise1_5.Bicycle;
import Exercise1_5.Cycle;
import Exercise1_5.Unicycle;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 17: Using the Cycle hierarchy from Exercise 1, add a balance( ) method to Unicycle and Bicycle, but not to Tricycle. Create instances of all three types and upcast them to an array of Cycle. Try to call balance( ) on each element of the array and observe the results. Downcast and call balance( ) and observe what happens.
 *      </body>
 * </html>
 */
public class Exercise17 {
    public static void main(String[] args) {
        System.out.println("Exercise 17 Result: ");

        // Upcasting:
        Cycle cycle = new Cycle();
        Bicycle bicycle = new Bicycle();
        Unicycle unicycle = new Unicycle();
        
        // ((Cycle) bicycle).balance();
        // ((Cycle) unicycle).balance();
        System.out.println("The method balance() is undefined for the type Cycle");

        // Downcasting:
        cycle = new Bicycle();
        ((Bicycle) cycle).balance();
        cycle = new Unicycle();
        ((Unicycle) cycle).balance();

        System.out.println("----------------------------------------------------");
    }
}
