import Exercise6.OwnPackage.SomeInterface;
import Exercise6.OwnPackage2.SomeClass;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 6: Create an interface with at least one method, in its own package. Create a class in a separate package. Add a protected inner class that implements the interface. In a third package, inherit from your class and, inside a method, return an object of the protected inner class, upcasting to the interface during the return.
 *      </body>
 * </html>
 */
public class Exercise6 extends SomeClass {
    SomeInterface foo() { return new Inner(); }
    public static void main(String[] args) {
        System.out.println("Exercise 6 Result: ");

        Exercise6 op = new Exercise6();
        SomeInterface si = op.foo();
        si.f();

        System.out.println("----------------------------------------------------");
    }
}