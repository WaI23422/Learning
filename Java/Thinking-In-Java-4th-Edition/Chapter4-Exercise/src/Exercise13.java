import static net.mindview.util.Print.*;

class Cup {
    Cup(int marker) {
        print("Cup(" + marker + ")");
    }
    void f(int marker) {
        print("f(" + marker + ")");
    }
}
class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups() {
        print("Cups()");
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
 *              <li>Exercise 13:    (1) Verify the statements in the following paragraph.
 *                  <ul>
 *                      <li>The static initializers for Cups run when either the access of the static object cup1
 *                      occurs on the line marked (1), or if line (1) is commented out and the lines marked (2) are
 *                      uncommented. If both (1) and (2) are commented out, the static initialization for Cups
 *                      never occurs, as you can see from the output. Also, it does not matter if one or both of the
 *                      lines marked (2) are uncommented; the static initialization only occurs once.</li>
 *                  </ul>
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */

public class Exercise13 {
    public static void main(String[] args) {
        System.out.println("Exercise 13 Result: ");

        print("Inside main()");
        Cups.cup1.f(99); // (1) 

        // static Cups cups1 = new Cups(); // (2)
        // static Cups cups2 = new Cups(); // (2) 

        System.out.println("----------------------------------------------------");
    }
}
