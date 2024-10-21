/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 16: Create a class called Amphibian. From this, inherit a class called Frog. Put appropriate methods in the base class. In main( ), create a Frog and upcast it to Amphibian and demonstrate that all the methods still work.
 *      </body>
 * </html>
 */
public class Exercise16 {
    public static void main(String[] args) {
        System.out.println("Exercise 16 Result: ");
        
        Frog frog = new Frog();

        frog.Action();

        Amphibian.Action(frog);

        frog.method();
        System.out.println("----------------------------------------------------");
    }
}

class Amphibian {
    static void Action(Amphibian a) {
        System.out.println("Do some action of Amphibian");
    }

    public void method() {
        System.out.println("Amphibian");
    }
}

class Frog extends Amphibian {
    void Action() {
        System.out.println("Do some action of Frog");
    }

    @Override
    public void method() {
        System.out.println("Frog");
    }
}