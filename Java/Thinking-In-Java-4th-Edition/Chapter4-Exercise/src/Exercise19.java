/**
 * <html>
 *      <head>
 *          <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *      </head>
 *      <body>
 *          <ol>
 *              <li>Exercise 19: Write a method that takes a vararg String array. Verify that you can pass either a comma-separated list of Strings or a String[] into this method.
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise19 {
    public static void ArargMethod(String... strArg){
        for (String string : strArg) {
            System.out.println("This is: "+string);
        }
    }
    public static void main(String[] args) {
        System.out.println("Exercise 19 Result: ");
        
        ArargMethod("a","b","c","d");

        System.out.println("----------------------------------------------------");
    }
}
