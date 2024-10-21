class ProtectedData{
    protected int valProtected=234;
}

class ManipulatesProtected extends ProtectedData{
    public int returnValProtected(){
        return valProtected;
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
 *         Exercise 6: Create a class with protected data. Create a second class in the same file with a method that manipulates the protected data in the first class.   
 *      </body>
 * </html>
 */
public class Exercise6 {
    public static void main(String[] args) {
        System.out.println("Exercise 6 Result: ");
        
        ManipulatesProtected manipulatesProtected = new ManipulatesProtected();

        System.out.println(manipulatesProtected.returnValProtected());

        System.out.println("----------------------------------------------------");
    }
}