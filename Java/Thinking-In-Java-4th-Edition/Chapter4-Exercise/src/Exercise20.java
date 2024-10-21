/**
 * <html>
 *      <head>
 *          <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *      </head>
 *      <body>
 *          <ol>
 *              <li>Exercise 20: Create a main( ) that uses varargs instead of the ordinary main( ) syntax. Print all the elements in the resulting args array. Test it with various numbers of command-line arguments
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise20 {
    public static void main(String... args) {
        System.out.println("Exercise 20 Result: ");
        
        for (String string : args) {
            System.out.println(string);
        }

        System.out.println("----------------------------------------------------");
    }
}
