class EmptyConstrutor{

}
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         <ol>
 *              <li>Exercise 7: Create a class without a constructor, and then create an object of that class in main( ) to verify that the default constructor is automatically synthesized.
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise7 {
    public static void main(String[] args) {
        System.out.println("Exercise 7 Result: ");
        
        EmptyConstrutor emptyConstrutor = new EmptyConstrutor();
        System.out.println(emptyConstrutor);

        System.out.println("----------------------------------------------------");
    }
}
