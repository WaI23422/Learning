/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 2: Create a class as abstract without including any abstract methods and verify that you cannot create any instances of that class.
 *      </body>
 * </html>
 */
public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("Exercise 2 Result: ");

        // AbstractClassWithNoAbstractMethod abs = new AbstractClassWithNoAbstractMethod();
        System.out.println("Cannot instantiate the type AbstractClassWithNoAbstractMethod");

        System.out.println("----------------------------------------------------");
    }
}

abstract class AbstractClassWithNoAbstractMethod {
    void print() {};
}