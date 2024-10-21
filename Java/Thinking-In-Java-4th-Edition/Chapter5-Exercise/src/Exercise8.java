import packexercise.exercise8.ConnectionManager;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 8: Following the form of the example Lunch.java, create a class called ConnectionManager that manages a fixed array of Connection objects. The client programmer must not be able to explicitly create Connection objects, but can only get them via a static method in ConnectionManager. When the ConnectionManager runs out of objects, it returns a null reference. Test the classes in main( ).
 *      </body>
 * </html>
 */
public class Exercise8 {
    public static void main(String[] args) {
        System.out.println("Exercise 8 Result: ");

        for (int i=0; i < 4; i++) {
            System.out.println(ConnectionManager.getConnection());
        }

        System.out.println("----------------------------------------------------");
    }
}