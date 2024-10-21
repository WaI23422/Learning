// Find the code for the second version of HelloDate.java, which is the
// simple comment documentation example. Execute Javadoc on the file and view the results
// with your Web browser  

/**
* Insert a list:
* <ol>
* <li> Item twelve
* </ol>
*/

//: object/HelloDate.java
import java.util.*;
/** The first Thinking in Java example program.
 * Displays a string and today’s date.
 * @author Bruce Eckel
 * @author www.MindView.net
 * @version 4.0
*/

    class HelloDate {
    /** Entry point to class & application.
     * @param args array of string arguments
     * @throws exceptions No exceptions thrown
     */
        public static void main(String[] args) {
            System.out.println("Hello, it’s: ");
            System.out.println(new Date());
        }
    } /* Output: (55% match)
    Hello, it’s:
    Wed Oct 05 14:39:36 MDT 2005
    *///:~ 

public class Exercise12 {
    public static void main(String[] args) {
        System.out.println("// Exercise 12 Result //");

        System.out.println("Excute code in cmd: javadoc Exercise12.java");
        
        System.out.println("View result: C:\\Users\\ADMIN\\Documents\\Programming\\Java Code\\Excercise\\Chapter1-Excercise\\src\\Exercise12.html ");

        System.out.println("----------------------------------------------------");
    }
}
