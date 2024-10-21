/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 17: Prove that the fields in an interface are implicitly static and final
 *      </body>
 * </html>
 */
public class Exercise17 {
    public static void main(String[] args) {
        System.out.println("Exercise 17 Result: ");

        System.out.println(FinalStatic.x); // Static
        //! Test.x = 321;
        //! Cannon asign a value to final variable x

        System.out.println("----------------------------------------------------");
    }
}

interface FinalStatic {
    int x = 123;
}
