import Protected.*;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 15: Create a class inside a package. Your class should contain a protected method. Outside of the package, try to call the protected method and explain the results. Now inherit from your class and call the protected method from inside a method of your derived class.
 *      </body>
 * </html>
 */
public class Exercise15 {
    public static void main(String[] args) {
        System.out.println("Exercise 15 Result: ");
        
        ProtectedClass protectedClass = new ProtectedClass();
        InheritProtectedClass inheritProtectedClass = new InheritProtectedClass();

        // protectedClass.print();

        System.out.println("The method print(String) in the type ProtectedClass is not applicable for the arguments ()");

        inheritProtectedClass.print();
        
        System.out.println("----------------------------------------------------");
    }
}

class InheritProtectedClass extends ProtectedClass {
    public void print(){
        print("This is print of Protected Class in Inheritance Class");
    }
}