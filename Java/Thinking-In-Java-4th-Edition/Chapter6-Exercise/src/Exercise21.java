/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 21: Create a class with a final method. Inherit from that class and attempt to overwrite that method.
 *      </body>
 * </html>
 */
public class Exercise21 {
    public static void main(String[] args) {
        System.out.println("Exercise 21 Result: ");
        
        Inherited inherit = new Inherited();

        inherit.OverrideMethod();

        System.out.println("----------------------------------------------------");
    }
}

class Final_21{
    final void Method() {
        System.out.println("This is a final method");
    }
}

class Inherited extends Final_21 {   
    // Cannot override the final method from Final 
    // void Method(int i) {
    //
    // }
    void OverrideMethod() {
        System.out.println("Cannot override the final method from Final");
    }
}