class InitializedString{
    String string;

    public InitializedString() {
        this.string = "string";
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
 *              <li>Exercise 15: Create a class with a String that is initialized using instance initialization. 
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise15 {
    public static void main(String[] args) {
        System.out.println("Exercise 15 Result: ");
        
        InitializedString initializedString = new InitializedString();
        System.out.println(initializedString.string);

        System.out.println("----------------------------------------------------");
    }
}
 