/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 3: Create a base class with an abstract print( ) method that is overridden in a derived class. The overridden version of the method prints the value of an int variable defined in the derived class. At the point of definition of this variable, give it a nonzero value. In the base-class constructor, call this method. In main( ), create an object of the derived type, and then call its print( ) method. Explain the results.
 *      </body>
 * </html>
 */
public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("Exercise 3 Result: ");
        
        derivedClass dC = new derivedClass();

        dC.print();

        System.out.println("----------------------------------------------------");
    }
}

abstract class BaseClass {
    abstract void print();
}

class derivedClass extends BaseClass {
    int x = 234;
    void print() {System.out.println(x);}
}