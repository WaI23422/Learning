/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 8: Determine whether an outer class has access to the private elements of its inner class.
 *      </body>
 * </html>
 */
public class Exercise8 {
    public static void main(String[] args) {
        System.out.println("Exercise 8 Result: ");

        Outer o = new Outer();
        o.testAccess();

        System.out.println("----------------------------------------------------");
    }
}

class Outer {
    class Inner {
        private int x = 123;
        private void print() { System.out.println("x = " + x); }
    }

    void testAccess() {
        Inner i = new Inner();
        i.print();
        i.x = 321;
        i.print();
    }
}