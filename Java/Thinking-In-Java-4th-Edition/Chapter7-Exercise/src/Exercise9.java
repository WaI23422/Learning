import Exercise9_12.Gerbil;
import Exercise9_12.Hamster;
import Exercise9_12.Mouse;
import Exercise9_12.Rodent;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 9: Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster, etc. In the base class, provide methods that are common to all Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent. Create an array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens.
 *      </body>
 * </html>
 */
public class Exercise9 {
    public static void main(String[] args) {
        System.out.println("Exercise 9 Result: ");
        
        Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster()};

        for (Rodent rodent : rodents) {
            rodent.move();
            rodent.gnaw();
        }

        System.out.println("----------------------------------------------------");
    }
}
