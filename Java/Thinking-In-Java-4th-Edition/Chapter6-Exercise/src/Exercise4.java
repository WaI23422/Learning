/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 4: Prove that the base-class constructors are (a) always called and (b) called before derived-class constructors.
 *      </body>
 * </html>
 */
public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("Exercise 4 Result: ");
        
        DerivedClass test = new DerivedClass();

        System.out.println(test);

        System.out.println("----------------------------------------------------");
    }
}

class BaseClass{
    BaseClass() {
        System.out.println("Base class Constructor Being Called");
    }
}

class DerivedClass extends BaseClass {
    DerivedClass() {
        System.out.println("Derived class Constructor Being Called");
    }
}