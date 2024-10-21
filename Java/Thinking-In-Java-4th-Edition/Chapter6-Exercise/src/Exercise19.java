/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 19: Create a class with a blank final reference to an object. Perform the initialization of the blank final inside all constructors. Demonstrate the guarantee that the final must be initialized before use, and that it cannot be changed once initialized.
 *      </body>
 * </html>
 */
public class Exercise19 {
    public static void main(String[] args) {
        System.out.println("Exercise 19 Result: ");
        
        Final final1 = new Final();

        final1.useOne();

        System.out.println("----------------------------------------------------");
    }
}

class Final{
    // static final int One -> The blank final field One may not have been initialized
    public final int One;

    Final () {
        One = 1;
        System.out.println("Final field being initialize");
    }

    void useOne() {
        System.out.println("Using Final field " + One);
    }
}