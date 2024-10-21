import packexercise.exercise7.access.Widget;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 7: Create the library according to the code fragments describing access and Widget. Create a Widget in a class that is not part of the access package. 
 *          <ul>
 *              <li> <code> import access.Widget </code>
 * 
 *              </li>
 *          </ul>
 *     </body>
 * </html>
 */
public class Exercise7 {
    public static void main(String[] args) {
        System.out.println("Exercise 7 Result: ");

        @SuppressWarnings("unused")
        Widget widget = new Widget();

        System.out.println("----------------------------------------------------");
    }
}