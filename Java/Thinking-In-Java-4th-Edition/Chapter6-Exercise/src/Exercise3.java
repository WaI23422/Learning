import static net.mindview.util.Print.*;

class Art {
    Art() { print("Art constructor"); }
}

class Drawing extends Art {
    Drawing() { print("Drawing constructor"); }
}

class Cartoon extends Drawing { 
    // public Cartoon() { print("Cartoon constructor"); }
    public static void main(String[] args) {
        Cartoon x = new Cartoon();
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
 *         Exercise 3: Prove the previous sentence.
 *          <ul>
 *              <li> Even if you don’t create a constructor for Cartoon( ), the compiler will synthesize a default constructor for you that calls the base class constructor.
 *      </body>
 * </html>
 */
public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("Exercise 3 Result: ");
        
        Cartoon.main(args);

        System.out.println("----------------------------------------------------");
    }
}