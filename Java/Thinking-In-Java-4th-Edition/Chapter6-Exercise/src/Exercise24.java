import static net.mindview.util.Print.*;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 24:  In Beetle.java, inherit a specific type of beetle from class Beetle, following the same format as the existing classes. Trace and explain the output. 
 *      </body>
 * </html>
 */
public class Exercise24 {
    public static void main(String[] args) {
        System.out.println("Exercise 24 Result: ");
        
        System.out.println("Book page 190");

        System.out.println("----------------------------------------------------");
    }
}

class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInit("static Insect.x1 initialized");
    static int printInit(String s) { 
        print(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }
    private static int x2 = printInit("static Beetle.x2 initialized");
    public static void main(String[] args) {
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
}