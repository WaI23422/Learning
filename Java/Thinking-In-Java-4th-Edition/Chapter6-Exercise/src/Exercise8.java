/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 8:  Create a base class with only a non-default constructor, and a derived class with both a default (no-arg) and non-default constructor. In the derived-class constructors, call the base-class constructor.
 *      </body>
 * </html>
 */
public class Exercise8 {
    public static void main(String[] args) {
        System.out.println("Exercise 8 Result: ");
        
        DerivedClassNonDefaultAndDefault test = new DerivedClassNonDefaultAndDefault(1);
        DerivedClassNonDefaultAndDefault test1 = new DerivedClassNonDefaultAndDefault();

        System.out.println("----------------------------------------------------");
    }
}

class BaseClassNonDefault{
    BaseClassNonDefault(int a) {
        System.out.println("This Is A Non-Default Base Class");
    }
}

class DerivedClassNonDefaultAndDefault extends BaseClassNonDefault{
    DerivedClassNonDefaultAndDefault() {
        super(0);
        System.out.println("This Is A Default Derived Class");
    }
    
    DerivedClassNonDefaultAndDefault(int a){
        super(a);
        System.out.println("This Is A Non-Default Derived Class");
    }
}