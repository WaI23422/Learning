class Tank{
    boolean isEmptie;

    public Tank(){}

    public Tank(boolean isEmptie){
        this.isEmptie = isEmptie;
    }

    void emptied(){
        isEmptie = true;
    }

    void filled(){
        isEmptie = false;
    }

    protected void finalize(){
        if (!isEmptie) {
            System.out.println("Error: is not Empty");
        }
    }
}
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         <ol>
 *              <li>Exercise 12: Create a class called Tank that can be filled and emptied, and has a
 *                  termination condition that it must be empty when the object is cleaned up. Write a
 *                  finalize( ) that verifies this termination condition. In main( ), test the possible scenarios
 *                  that can occur when your Tank is used
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise12 {
    public static void main(String[] args) {
        System.out.println("Exercise 12 Result: ");
        
        // Create a new tank.
        Tank tank = new Tank();
        // Fill the Tank.
        tank.filled();
        // Empty the Tank;
        tank.emptied();
        // Reference of Tank without object:
        new Tank(false);
        // Cleaning
        System.gc();

        System.out.println("----------------------------------------------------");
    }
}
