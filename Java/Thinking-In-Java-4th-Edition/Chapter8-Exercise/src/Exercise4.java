/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 4: Create an abstract class with no methods. Derive a class and add a method. Create a static method that takes a reference to the base class, downcasts it to the derived class, and calls the method. In main( ), demonstrate that it works. Now put the abstract declaration for the method in the base class, thus eliminating the need for the downcast.
 *      </body>
 * </html>
 */
public class Exercise4 {

    static void testMethod1(abstractClass1 b) {
        ((Derived1) b).print();
    }

    static void testMethod2(abstractClass2 b) {
        b.print();
    }

    public static void main(String[] args) {
        System.out.println("Exercise 4 Result: ");

        Derived1 d1 = new Derived1();
        Derived2 d2 = new Derived2();

        testMethod1(d1);
        testMethod2(d2);

        System.out.println("----------------------------------------------------");
    }
}

abstract class abstractClass1 {}

class Derived1 extends abstractClass1 {
    void print() {
        System.out.println("This is a derived class 1");
    }
}

abstract class abstractClass2 {
    abstract void print();
}

class Derived2 extends abstractClass2 {
    void print() { System.out.println("This is a derived class 2"); }
}