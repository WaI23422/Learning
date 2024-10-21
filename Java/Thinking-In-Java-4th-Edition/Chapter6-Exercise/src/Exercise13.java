/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 13: Create a class with a method that is overloaded three times. Inherit a new class, add a new overloading of the method, and show that all four methods are available in the derived class.
 *      </body>
 * </html>
 */
public class Exercise13 {
    public static void main(String[] args) {
        System.out.println("Exercise 13 Result: ");
        
        OverLoaded overLoaded = new OverLoaded();

        InheritOverLoaded inheritOverLoaded = new InheritOverLoaded();

        System.out.println("----------------------------------------------------");
    }
}

class OverLoaded {

    public void overLoaded(){

    }

    public void overLoaded(String string){

    }

    public void overLoaded(int i){

    }
}

class InheritOverLoaded extends OverLoaded {

    public void overLoaded(String string, int i){

    }
}