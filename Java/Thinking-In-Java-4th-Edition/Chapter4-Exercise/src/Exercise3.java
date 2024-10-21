
class MyPrint{
    // Constructor    
    public MyPrint(){
        System.out.println("This is Default Constructor.");
    }
    // Overload Constructor - Exercise 4.
    public MyPrint(String mess){
        System.out.println("This is Overloading Parameter: "+ mess);
    }
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
 *              <li>Exercise 3: Create a class with a default constructor (one that takes no arguments) that prints a message. Create an object of this class.
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("Exercise 3 Result: ");
        
        MyPrint myPrint = new MyPrint();

        System.out.println("----------------------------------------------------");
    }
}
