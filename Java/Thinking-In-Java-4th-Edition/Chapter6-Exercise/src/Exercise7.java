/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 7: Modify Exercise 5 so that A and B have constructors with arguments instead of default constructors. Write a constructor for C and perform all initialization within C’s constructor. 
 *      </body>
 * </html>
 */
public class Exercise7 {
    public static void main(String[] args) {
        System.out.println("Exercise 7 Result: ");

        C7.main(args);

        System.out.println("----------------------------------------------------");
    }
}

class A7{
    A7(int a) {
        System.out.println("Class A");
    }
}

class B7{
    B7(int b) {
        System.out.println("Class B");
    }
}

class C7 extends A7 {
    C7(int c){
        super(4);
        System.out.println("Class C");
    }

    public static void main(String[] args) {
        B7 b = new B7(0);
        A7 a = new A7(0);
        C7 c = new C7(0);
    }
}