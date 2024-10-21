/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 13: Create an interface, and inherit two new interfaces from that interface. Multiply inherit a third interface from the second two.
 *      </body>
 * </html>
 */
public class Exercise13 {
    public static void main(String[] args) {
        System.out.println("Exercise 13 Result: ");

        AllInOne a = new AllInOne();
        a.f();

        System.out.println("----------------------------------------------------");
    }
}

interface Learning {
    void f();
}

interface Note extends Learning {
    void f();
}

interface Exercise extends Learning {
    void f();
}

interface Action extends Note, Exercise {
    void f();
}

class AllInOne implements Action {
    public void f() {System.out.println("Doing All");};
}