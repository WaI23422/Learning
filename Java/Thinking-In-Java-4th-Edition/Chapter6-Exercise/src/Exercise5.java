/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 5:  Create two classes, A and B, with default constructors (empty argument lists) that announce themselves. Inherit a new class called C from A, and create a member of class B inside C. Do not create a constructor for C. Create an object of class C and observe the results.
 *      </body>
 * </html>
 */
public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("Exercise 5 Result: ");
        
        C c = new C();

        System.out.println("----------------------------------------------------");
    }
}

class A{
    A() {
        System.out.println("Class A");
    }
}

class B{
    B() {
        System.out.println("Class B");
    }
}

class C extends A {
    B b = new B();
}