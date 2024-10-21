import Exercise6.Interface.someInterface;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 6: Prove that all the methods in an interface are automatically public
 *      </body>
 * </html>
 */
public class Exercise6 {
    public static void main(String[] args) {
        System.out.println("Exercise 6 Result: ");

        System.out.println("----------------------------------------------------");
    }
}

class Derived implements someInterface {
    public void method1() {}
    public void method2() {}
    public void method3() {}

    // Cannot reduce the visibility of the inherited method from someInterface
    // @Override void method1() {} -> not public 
    // @Override void method2() {} -> not public
    // @Override void method3() {} -> not public
    // !ERRORS:
    // !methodX() in Derived cannot implement methodX() in somepackage.Base
    // !attempting to assign weaker access privileges; was public
}
