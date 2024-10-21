
class MyMethods{
    public void Method1(){
        System.out.println("This is method 1");
        Method2();

        this.Method2();
    }

    public void Method2(){
        System.out.println("This is method 2");
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
 *              <li>Exercise 8: Create a class with two methods. Within the first method, call the second method twice: the first time without using this, and the second time using this—just to see it working; you should not use this form in practice. 
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise8 {
    public static void main(String[] args) {
        System.out.println("Exercise 8 Result: ");
        
        MyMethods myMethods = new MyMethods();
        myMethods.Method1();

        System.out.println("----------------------------------------------------");
    }
}
