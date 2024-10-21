
class OverloadConstruc{
    public OverloadConstruc(){
        this("2");
        System.out.println("This is Constructor: 1");
    }

    public OverloadConstruc(String str){
        System.out.println("This is Constructor: " + str);
    }
}

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         <ol>
 *              <li>Exercise 9: Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one. 
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise9 {
    public static void main(String[] args) {
        System.out.println("Exercise 9 Result: ");
        
        OverloadConstruc call = new OverloadConstruc();

        System.out.println("----------------------------------------------------");
    }
}
