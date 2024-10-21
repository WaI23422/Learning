import packexercise.exercise3.debug.debugTwin;
// import packexercise.exercise3.debug.*;
// import packexercise.exercise3.debugoff.*;
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 3: Create two packages: debug and debugoff, containing an identical class with a debug( ) method. The first version displays its String argument to the console, the second does nothing. Use a static import line to import the class into a test program, and demonstrate the conditional compilation effect.
 *     </body>
 * </html>
 */
public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("Exercise 3 Result: ");

        debugTwin debugtwin = new debugTwin();

        debugtwin.debug("String");

        System.out.println("----------------------------------------------------");
    }
}