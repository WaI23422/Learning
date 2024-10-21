import Exercise5.InnerInstance;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise5 : Create a class with an inner class. In a separate class, make an instance of the inner class.
 *      </body>
 * </html>
 */
public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("Exercise5 Result: ");

        new InnerInstance();
        new InnerInstance(123);

        System.out.println("----------------------------------------------------");
    }
}