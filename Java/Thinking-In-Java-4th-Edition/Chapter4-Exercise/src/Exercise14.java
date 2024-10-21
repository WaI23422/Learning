class staticString{
    static String str1 = "string 1";
    static String str2;

    static {str2 = "string 2";}
}
/**
 * <html>
 *      <head>
 *          <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *      </head>
 *      <body>
 *          <ol>
 *              <li>Exercise 14: Create a class with a static String field that is initialized at the point of
 *                      definition, and another one that is initialized by the static block. Add a static method that
 *                      prints both fields and demonstrates that they are both initialized before they are used.
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise14 {
    public static void main(String[] args) {
        System.out.println("Exercise 14 Result: ");
        
        System.out.println(staticString.str1);
        System.out.println(staticString.str2);

        System.out.println("----------------------------------------------------");
    }
}
