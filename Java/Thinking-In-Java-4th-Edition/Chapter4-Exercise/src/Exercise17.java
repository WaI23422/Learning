
class TakeString{
    public TakeString(String str){
        System.out.println(str);
    }
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
 *              <li>Exercise 17: Create a class with a constructor that takes a String argument. During construction, print the argument. Create an array of object references to this class, but don’t actually create objects to assign into the array. When you run the program, notice whether the initialization messages from the constructor calls are printed.
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise17 {
    public static void main(String[] args) {
        System.out.println("Exercise 17 Result: ");
        
        TakeString takeString = new TakeString("Reference of Object");

        System.out.println("----------------------------------------------------");
    }
}
