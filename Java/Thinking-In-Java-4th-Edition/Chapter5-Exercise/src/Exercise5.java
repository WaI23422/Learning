import packexercise.exercise5.*;
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 5: Create a class with public, private, protected, and package-access fields and method members. Create an object of this class and see what kind of compiler messages you get when you try to access all the class members. Be aware that classes in the same directory are part of the “default” package.  
 *      </body>
 * </html>
 */
public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("Exercise 5 Result: ");

        Access access = new Access();

        access.PublicAccess();

        System.out.println("----------------------------------------------------");
    }
}