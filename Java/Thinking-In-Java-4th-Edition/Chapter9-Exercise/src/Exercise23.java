import Exercise22_23.ThreeMethods;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 23: Create an interface U with three methods. Create a class A with a method that produces a reference to a U by building an anonymous inner class. Create a second class B that contains an array of U. B should have one method that accepts and stores a reference to a U in the array, a second method that sets a reference in the array (specified by the method argument) to null, and a third method that moves through the array and calls the methods in U. In main( ), create a group of A objects and a single B. Fill the B with U references produced by the A objects. Use the B to call back into all the A objects. Remove some of the U references from the B.
 *      </body>
 * </html>
 */
public class Exercise23 {
    public static void main(String[] args) {
        System.out.println("Exercise 23 Result: ");

        ThreeMethods.main(args);

        System.out.println("----------------------------------------------------");
    }
}