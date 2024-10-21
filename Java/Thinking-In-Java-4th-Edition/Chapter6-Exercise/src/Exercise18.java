/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 18: Create a class with a static final field and a final field and demonstrate the difference between the two.
 *      </body>
 * </html>
 */
public class Exercise18 {

    static final int One = 1;
    final int Two = 2;
    public static void main(String[] args){
        System.out.println("Exercise 18 Result: ");

        System.out.println(Exercise18.One);
        // System.out.println(Exercise18.Two);
        System.out.println("Cannot make a static reference to the non-static field Exercise18.Two");

        // System.out.println(Exercise18.One = 2);
        System.out.println("The final field Exercise18.One cannot be assigned");

        System.out.println("----------------------------------------------------");
    }
}