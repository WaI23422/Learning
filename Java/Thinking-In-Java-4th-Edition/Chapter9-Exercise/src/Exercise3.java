import Exercise1_3.OuterEx1_Modified;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 3: Modify Exercise 1 so that Outer has a private String field (initialized by the constructor), and Inner has a toString( ) that displays this field. Create an object of type Inner and display it
 *      </body>
 * </html>
 */
public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("Exercise 3 Result: ");
        
        OuterEx1_Modified o = new OuterEx1_Modified("Outer string");
        OuterEx1_Modified.InnerEx1 i = o.getInner();

        i.print();
        System.out.println(i.toString());
        System.out.println(o);

        System.out.println("----------------------------------------------------");
    }
}

