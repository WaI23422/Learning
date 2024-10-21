
class MyClass {
    private String stringRef;

    public MyClass() {
        // The stringRef reference is uninitialized here.
    }

    public void printStringRef() {
        System.out.println(stringRef);
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
 *              <li>Exercise 1: Create a class containing an uninitialized String reference. Demonstrate that this reference is initialized by Java to null. 
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("Exercise 1 Result: ");
        
        MyClass myClass = new MyClass();
        myClass.printStringRef();

        System.out.println("----------------------------------------------------");
    }
}