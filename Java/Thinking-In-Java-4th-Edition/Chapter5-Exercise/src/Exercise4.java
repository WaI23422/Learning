import packexercise.exercise4.*;
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 4: Show that protected methods have package access but are not public.  
 *      </body>
 * </html>
 */
public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("Exercise 4 Result: ");

        ProtectedAccess protectedAccess = new ProtectedAccess();
        
        protectedAccess.publicMethod();
        // protectedAccess.ProtectedMethod; 
        //   Syntax error, insert "VariableDeclarators" to complete LocalVariableDeclaration.
        //   ProtectedMethod cannot be resolved or is not a field.

        System.out.println("----------------------------------------------------");
    }
}