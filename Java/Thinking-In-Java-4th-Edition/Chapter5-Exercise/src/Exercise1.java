import packexercise.exercise1.*;
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 1:  Create a class in a package. Create an instance of your class outside of that package.
 *      </body>
 * </html>
 */
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("Exercise 1 Result: ");

        // Instance of a class outside a package
        PackClass packClass = new PackClass();
        packClass.printString();

        System.out.println("----------------------------------------------------");
    }
}