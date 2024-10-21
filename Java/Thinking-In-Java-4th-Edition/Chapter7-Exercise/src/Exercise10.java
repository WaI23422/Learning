import Exercise10.BaseClass;
import Exercise10.DerivedClass;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 10: Create a base class with two methods. In the first method, call the second method. Inherit a class and override the second method. Create an object of the derived class, upcast it to the base type, and call the first method. Explain what happens.
 *      </body>
 * </html>
 */
public class Exercise10 {
    public static void main(String[] args) {
        System.out.println("Exercise 10 Result: ");

        DerivedClass derivedClass = new DerivedClass();

        derivedClass.method1();

        BaseClass baseClass = new BaseClass();

        baseClass.method1();

        System.out.println("----------------------------------------------------");
    }
}
