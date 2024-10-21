import java.util.Random;
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 23: Prove that class loading takes place only once. Prove that loading may be caused by either the creation of the first instance of that class or by the access of a static member.
 *      </body>
 * </html>
 */
public class Exercise23 {
    static Random r = new Random();
    static int i = r.nextInt();
    public static void main(String[] args) {
        System.out.println("Proving that class loading takes place only once, since static fields are initialized when class loads");
        
        System.out.println("Proving that loading may be caused by the access of a static member");
        System.out.println("LoadingClass is loaded now, and z=" + LoadingClass.z);
    
    }
}


class LoadingClass {
    static int z = 11;
}