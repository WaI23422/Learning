/**
 * <html>
 *      <head>
 *          <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *      </head>
 *      <body>
 *          <ol>
 *              <li>Exercise 16: Create an array of String objects and assign a String to each element. Print the array by using a for loop.
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise16 {
    public static void main(String[] args) {
        System.out.println("Exercise 16 Result: ");
    
        int[] intArr = {1,2,3,4};

        for (int i : intArr) {
            System.out.println(i);
        }

        System.out.println("----------------------------------------------------");
    }
}
