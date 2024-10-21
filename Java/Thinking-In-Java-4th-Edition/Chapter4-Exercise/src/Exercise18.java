/**
 * <html>
 *      <head>
 *          <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *      </head>
 *      <body>
 *          <ol>
 *              <li>Exercise 18: Complete the previous exercise by creating objects to attach to the array of references.
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise18 {
    public static void main(String[] args) {
        System.out.println("Exercise 18 Result: ");

        TakeString[] takeString = new TakeString[5];

        for (int i = 0; i < takeString.length; i++) {
            takeString[i] = new TakeString("null");
        }

        System.out.println("----------------------------------------------------");
    }
}
