
class ObjectCheck{
    boolean CleanedOut;
    ObjectCheck(boolean CleanOut){
        finalize();
        CleanedOut = CleanOut;
    }

    void StillUse(){
        CleanedOut = false;
    }

    protected void finalize(){
        if(!CleanedOut){
            System.out.println("Error: Haven't Clean");
        }
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
 *              <li>Exercise 10: Create a class with a finalize( ) method that prints a message. In main( ), create an object of your class. Explain the behavior of your program. 
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise10 {
    public static void main(String[] args) {
        System.out.println("Exercise 10 Result: ");
        // Create new object with reference have parameter true
        ObjectCheck object = new ObjectCheck(true);
        // Object still using don't need to be cleaned.
        object.StillUse();
        // Reference being created without clean-up:
        new ObjectCheck(true);
        // Clean-up Reference by force garbage collection:
        System.gc();

        System.out.println("----------------------------------------------------");
    }
}
