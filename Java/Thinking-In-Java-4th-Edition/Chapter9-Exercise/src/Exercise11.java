// import Exercise9_10_11.PrivateInner;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 11: Create a private inner class that implements a public interface. Write a method that returns a reference to an instance of the private inner class, upcast to the interface. Show that the inner class is completely hidden by trying to downcast to it.
 *      </body>
 * </html>
 */
public class Exercise11 {
    public static void main(String[] args) {
        System.out.println("Exercise 11 Result: ");

        // PrivateInner pi = new PrivateInner();
        // PrivateInnerInterface p1 = pi.getInner(); - The method getInner() from the type PrivateInner is not visible
        // Inner p2 = (Inner) p1; - Inner cannot be resolved to a type
        // p2.f();  

        System.out.println("----------------------------------------------------");
    }
}