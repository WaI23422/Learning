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
 *         Exercise 12: Modify Exercise 9 so that it demonstrates the order of initialization of the base classes and derived classes. Now add member objects to both the base and derived classes and show the order in which their initialization occurs during construction
 *      </body>
 * </html>
 */
public class Exercise12 {
    public static void main(String[] args) {
        System.out.println("Exercise 12 Result: ");

        Rodent rodent = new Rodent();
        Hamster hamster = new Hamster();
        Mouse mouse = new Mouse();
        Gerbil gerbil = new Gerbil(); 

        rodent.dispose();
        hamster.dispose();
        mouse.dispose();
        gerbil.dispose();


        System.out.println("----------------------------------------------------");
    }
}
